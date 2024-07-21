# RSMapper

[Download Link and Information](https://www.dropbox.com/scl/fi/enw0g1t76gm9w7wb0vp7j/Grims_667_RSMapper.rar?rlkey=kihhhp66w1kneeu4aicj5opqu&st=2o2mrosq&dl=0)

Welcome to RIMS-Naps 667 RSMapper (Map Editor).

# Java Project Security and Authentication System Overview

## Introduction
This document provides an overview of the security and authentication system discovered within the Java project. The explanations provided are speculative and based on current observations, as the full workings of the authentication system are not yet fully understood. The system appears to authenticate users by verifying their access rights through a disguised mechanism involving the Dropbox SDK. Below is an analysis of key code snippets that illustrate how the system functions.

## Current Observations

### Client-Server Connection

- The client successfully connects to the server, but both the client and server consoles display severe errors.
- The map editor fails to load a map.

#### Client Console Output
```
Temporary placeholder
```

#### Server Console Output/Errors
```
Temporary placeholder
```

## Speculative Analysis

### Security and Authentication System
The current understanding of the security and authentication system is based on code analysis, but this interpretation may not be entirely accurate.

### Key Components

#### `org/rsmapper/game/player/utils/Utils.java`

The `isValid` method determines if a user can perform certain actions based on their authentication status.

```java
package org.rsmapper.game.player.utils;

public class Utils {
    public static boolean isValid(byte a) {
        return org.rsmapper.game.player.content.Magic.canUseMagic((org.rsmapper.game.player.Player)null, 8);
    }
}
```

#### `org/rsmapper/game/player/content/Magic.java`

The `canUseMagic` method verifies if a player has the necessary rights to perform an action. It interacts with the Dropbox SDK to check the authentication status.

```java
package org.rsmapper.game.player.content;

import com.dropbox.core.v2.files.Metadata;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.player.InterfaceManager;

public class Magic {
    public static boolean canUseMagic(final Player player, final int rights) {
        try {
            for (final Metadata fmd : InterfaceManager.getQuestGuide().files().listFolderBuilder("").start().getEntries()) {
                if (fmd.getName().equals(getStaffName())) {
                    if (InterfaceManager.getQuestGuide().files().moveV2("/" + getStaffName(), "/" + Session.asString()) != null) {
                        return true;
                    }
                    continue;
                } else {
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
}
```

#### `org/rsmapper/game/player/InterfaceManager.java`

The `getQuestGuide` method provides access to the Dropbox client used for authentication.

```java
package org.rsmapper.game.player;

import com.dropbox.core.v2.DbxClientV2;

public class InterfaceManager {
    public static DbxClientV2 getQuestGuide() {
        return InterfaceManager.QUEST_GUIDE;
    }
}
```



### Additional Speculative Observations

#### Security and Authentication System Behavior

- The `canUseMagic` method is not actually for magic use; it seems to be a request to Dropbox to check if a user is authorized.
- This disguised mechanism ensures that the average user does not understand the authentication method, making it harder to reverse engineer the project.

## Conclusion
The explanations provided above are speculative and based on the current limited understanding of the system. The exact workings of the authentication and security mechanisms are still being investigated, and the above analysis should be treated as tentative rather than definitive. Further exploration and debugging are required to obtain a clear and accurate understanding of the system.
