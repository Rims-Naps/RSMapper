import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Project implements Serializable {
   private static final long serialVersionUID = 3310749815398877515L;
   String name;
   public ArrayList<Object[]> quickLoads;
   public Date dateCreated;
   public Date dateModified;

   public Project(String name) {
      this.name = name;
      if (this.quickLoads == null) {
         this.quickLoads = new ArrayList<>();
      }

      if (this.dateCreated == null) {
         this.dateCreated = new Date();
      }

      if (this.dateModified == null) {
         this.dateModified = new Date();
      }
   }

   public void setDateModified() {
      this.dateModified = new Date();
   }

   public void addToQuickLoad(Object[] data) {
      this.removeQuickLoad(data);
      this.quickLoads.add(0, data);
   }

   public void removeQuickLoad(Object[] data) {
      Iterator<Object[]> it$ = this.quickLoads.iterator();

      while(it$.hasNext()) {
         Object[] quickload = it$.next();
         int region = (int)quickload[0]; //line 42
         if (region == (int)data[0]) { //line 43
            it$.remove();
            break;
         }
      }
   }

   public ArrayList<Object[]> getRegionSearches() {
      return this.quickLoads;
   }

   public int getRegionAtIndex(int index) {
      return (int)this.quickLoads.get(index)[0]; //line 55
   }

   public String getNoteAtIndex(int index) {
      return (String)this.quickLoads.get(index)[1];
   }

   public int getIndexOfQuickLoad(Object[] data, boolean compareNote) {
      int index = 0;

      for(Object[] quickload : this.quickLoads) {
         int region = (int)quickload[0]; //line 66 - Fixed the issue by explicitly casting to int
         String note = (String)quickload[1];
         if (region == (int)data[0] && !compareNote || region == (int)data[0] && compareNote && note.equals((String)data[1])) {
            return index;
         }

         ++index;
      }

      return -1;
   }

   public void setNoteForRegion(int regionId, String note) {
      Object[] newQuickLoad = null;
      int index = 0;

      for(Iterator<Object[]> it$ = this.quickLoads.iterator(); it$.hasNext(); ++index) {
         Object[] quickload = it$.next();
         int region = (int)quickload[0];
         if (region == regionId) {
            newQuickLoad = new Object[]{region, note};
            it$.remove();
            break;
         }
      }

      if (newQuickLoad != null) {
         this.quickLoads.add(index, newQuickLoad);
      }
   }

   public void sortQuickLoads(ArrayList<Integer> regionIds) {
      ArrayList<Object[]> newQuickloads = new ArrayList<>();
      int index = 0;

      for(int i = 0; i < this.quickLoads.size(); ++i) {
         for(int j = 0; j < regionIds.size(); ++j) {
            if (regionIds.get(j) == this.quickLoads.get(i)[0]) {
               Object[] temp = (Object[])this.quickLoads.get(this.getIndexOfQuickLoad(new Object[]{regionIds.get(j), ""}, false));
               this.removeQuickLoad(new Object[]{regionIds.get(j), ""});
               newQuickloads.add(index++, temp);
            }
         }
      }

      this.quickLoads.clear();
      this.quickLoads = newQuickloads;
   }

   public ArrayList<Integer> getRegionIds() {
      ArrayList<Integer> regionIds = new ArrayList<>();

      for(int i = 0; i < this.quickLoads.size(); ++i) {
         regionIds.add((Integer) this.quickLoads.get(i)[0]);
      }

      return regionIds;
   }

   public boolean containsRegion(int regionId) {
      for (int i = 0; i < this.quickLoads.size(); ++i) {
         int region = (int) this.quickLoads.get(i)[0];
         if (region == regionId) {
            return true;
         }
      }

      return false;
   }
}
