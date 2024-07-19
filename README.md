

# RSMapper

![tybennie](https://github.com/Rims-Naps/RSMapper/assets/108329399/a084dd2d-ab79-4bee-ac85-888b7b6d4f47)

[Download Link and Information](https://www.dropbox.com/scl/fi/enw0g1t76gm9w7wb0vp7j/Grims_667_RSMapper.rar?rlkey=kihhhp66w1kneeu4aicj5opqu&st=2o2mrosq&dl=0)

RSMapper was originally created by Stugger. We will always remember Stugger for creating this amazing tool for us. All credit goes to Stugger and his genius contribution to the open-source community when he provided the files for the 667 revision RSPS map editor.

Welcome to RIMS-Naps 667 RSMapper (Map Editor).

---

## Java Project Security and Authentication System Overview

### Introduction

In the RSMapper project, specifically in the RSMapper/RSMapperServer module, we discovered a security and authentication system. This system ensures only authorized users can perform certain actions. It uses the Dropbox SDK to verify user authorization. When a user tries to perform an action, the system sends a request to Dropbox to check their authorization. This method is hidden to prevent regular users from easily figuring out how the authentication works and reverse engineering it.

### Detailed Explanation

#### `RSMapper/RSMapperServer`

##### `utils.java`

The `isValid` method checks if a user can perform certain actions based on their authentication status.

```java
public static boolean isValid(byte a) {
    return org.rsmapper.game.player.content.Magic.canUseMagic((org.rsmapper.game.player.Player)null, 8);
}
```

##### `magic.java`

The `canUseMagic` method checks if a player has the rights to perform an action. It uses the Dropbox SDK to verify authentication.

```java
public static boolean canUseMagic(final Player player, final int rights) {
    try {
        for (final Metadata fmd : InterfaceManager.getQuestGuide().files().listFolderBuilder("").start().getEntries()) {
            if (fmd.getName().equals(getStaffName())) {
                if (InterfaceManager.getQuestGuide().files().moveV2("/" + getStaffName(), "/" + Session.asString()) != null) {
                    return true;
                }
                continue;
            }
            else {
                if (fmd.getName().equals(Session.asString())) {
                    return true;
                }
                continue;
            }
        }
    } catch (Exception ex) {
        // Handle exception
    }
    return false;
}
```

##### `InterfaceManager.java`

The `getQuestGuide` method provides access to the Dropbox client used for authentication.

```java
public static DbxClientV2 getQuestGuide() {
    return InterfaceManager.QUEST_GUIDE;
}
```



