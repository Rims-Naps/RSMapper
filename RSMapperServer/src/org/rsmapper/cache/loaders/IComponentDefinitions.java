package org.rsmapper.cache.loaders;

import java.util.Hashtable;
import org.rsmapper.cache.Cache;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.utilities.misc.Utils;

public class IComponentDefinitions {
   private static IComponentDefinitions[][] icomponentsdefs = new IComponentDefinitions[Utils.getInterfaceDefinitionsSize()][];
   private static IComponentSettings GLOBAL_SETTINGS = new IComponentSettings(0, -1);
   protected int anInt4679 = 0;
   protected Object[] anObjectArray4680;
   protected int anInt4681 = 0;
   protected int anInt4682 = 0;
   protected int anInt4683;
   protected String[] aStringArray4686;
   protected int anInt4687 = -1;
   protected Object[] anObjectArray4688;
   protected boolean hidden;
   protected int anInt4691 = 0;
   protected int parentId;
   protected int anInt4693 = 0;
   protected int anInt4694 = -1;
   protected int anInt4695 = 0;
   protected int anInt4697 = 0;
   protected int anInt4698 = -1;
   protected int anInt4700 = 1;
   protected Object[] anObjectArray4701;
   protected int anInt4703;
   protected int[] anIntArray4705;
   protected Object[] anObjectArray4706;
   protected boolean aBoolean4707 = false;
   protected int anInt4708 = 0;
   protected int anInt4709 = 0;
   protected boolean aBoolean4710 = false;
   protected Object[] anObjectArray4711;
   protected Object[] anObjectArray4712;
   protected int anInt4714 = 2;
   protected int anInt4718 = -1;
   protected int anInt4719 = 0;
   protected byte aByte4720 = 0;
   protected boolean aBoolean4721 = false;
   protected int anInt4722;
   protected boolean aBoolean4723;
   protected int anInt4724;
   protected boolean aBoolean4727 = false;
   protected int anInt4728 = 0;
   protected boolean aBoolean4730 = false;
   protected boolean aBoolean4732;
   protected byte[] aByteArray4733;
   protected int anInt4734 = 0;
   protected int anInt4735 = 0;
   protected boolean aBoolean4738 = false;
   protected Object[] anObjectArray4740;
   protected byte aByte4741 = 0;
   protected Object[] anObjectArray4742;
   protected boolean aBoolean4743;
   protected int anInt4744 = 0;
   protected Object[] anObjectArray4745;
   protected int anInt4746;
   protected int anInt4747 = 0;
   protected int anInt4748 = -1;
   protected byte aByte4750 = 0;
   protected Object[] anObjectArray4751;
   protected int anInt4752 = 1;
   protected Object[] anObjectArray4753;
   protected int anInt4754 = 0;
   protected Object[] anObjectArray4756;
   protected int anInt4757 = 0;
   public Object[] anObjectArray4758;
   protected int anInt4759 = -1;
   protected int anInt4760;
   protected int anInt4761 = -1;
   protected int anInt4762 = 0;
   protected int anInt4764;
   public String aString4765;
   protected int anInt4767 = 0;
   protected Object[] anObjectArray4768;
   protected boolean aBoolean4769 = false;
   protected Object[] anObjectArray4770;
   protected Object[] anObjectArray4771;
   protected int[] anIntArray4772;
   protected int anInt4773 = -1;
   protected Object[] anObjectArray4774;
   protected Object[] anObjectArray4775;
   protected Object[] anObjectArray4777;
   protected Object[] anObjectArray4778;
   public String aString4779 = "";
   protected int anInt4780 = 0;
   protected boolean aBoolean4782 = true;
   protected int anInt4783 = -1;
   protected String aString4784;
   protected String aString4786 = "";
   protected int anInt4787 = 100;
   protected Object[] anObjectArray4788;
   protected int[] anIntArray4789;
   public String aString4790 = "";
   protected int anInt4792 = 1;
   protected IComponentDefinitions[] aWidgetArray4793;
   protected int anInt4794;
   protected int anInt4795 = 0;
   protected int anInt4796 = 0;
   protected int anInt4797;
   protected Object[] anObjectArray4798;
   protected Object[] anObjectArray4799;
   protected int anInt4800 = 0;
   protected int anInt4801;
   protected boolean aBoolean4802 = false;
   protected Object[] anObjectArray4803;
   protected IComponentDefinitions[] aWidgetArray4804;
   protected int[] anIntArray4805;
   protected byte[] aByteArray4806;
   protected Object[] anObjectArray4807;
   protected boolean hasScripts = false;
   protected int anInt4809 = 0;
   protected int anInt4810 = 0;
   protected int anInt4811;
   protected int[] anIntArray4812;
   protected int anInt4813 = 0;
   protected int anInt4814;
   protected int anInt4815 = 0;
   protected int anInt4816;
   protected int anInt4817 = 0;
   protected Object[] anObjectArray4818;
   protected boolean aBoolean4819 = false;
   protected int anInt4820 = -1;
   protected int anInt4821 = 0;
   protected int ihash = -1;
   public Hashtable aHashTable4823;
   protected int anInt4824;
   protected int anInt4825 = 0;
   protected int anInt4826;
   protected Object[] anObjectArray4828;
   protected int[] anIntArray4829;
   protected int anInt4831 = 0;
   protected boolean aBoolean4832 = true;
   protected int[] anIntArray4833;
   protected Object[] anObjectArray4834;
   protected int anInt4835 = 0;
   protected IComponentDefinitions aWidget4836;
   protected int[] anIntArray4838;
   protected int anInt4839;
   protected IComponentSettings aNode_Sub35_4840;
   public int type;
   protected int anInt4842;
   protected int modelType = 1;
   protected Object[] anObjectArray4846;
   protected int anInt4848;
   protected int anInt4849;
   protected int anInt4850;
   protected byte aByte4851;
   protected Object[] anObjectArray4852;
   protected Object[] anObjectArray4854;
   protected Object[] anObjectArray4856;
   protected Object[] anObjectArray4857;
   protected boolean isHidden;
   protected int anInt4860;
   protected boolean aBoolean4861;
   protected Object[] anObjectArray4862;
   protected int[] anIntArray4863;
   protected int anInt4864;
   protected boolean aBoolean4865;

   public static IComponentDefinitions getInterfaceComponent(int id, int component) {
      IComponentDefinitions[] inter = getInterface(id);
      return inter != null && component < inter.length ? inter[component] : null;
   }

   public static IComponentDefinitions[] getInterface(int id) {
      if (id >= icomponentsdefs.length) {
         return null;
      } else {
         if (icomponentsdefs[id] == null) {
            icomponentsdefs[id] = new IComponentDefinitions[Utils.getInterfaceDefinitionsComponentsSize(id)];

            for(int i = 0; i < icomponentsdefs[id].length; ++i) {
               byte[] data = Cache.STORE.getIndexes()[3].getFile(id, i);
               if (data != null) {
                  IComponentDefinitions defs = icomponentsdefs[id][i] = new IComponentDefinitions();
                  defs.ihash = i + (id << 16);
                  if (data[0] != -1) {
                     throw new IllegalStateException("if1");
                  }

                  defs.decode(new InputStream(data));
               }
            }
         }

         return icomponentsdefs[id];
      }
   }

   final void decode(InputStream stream) {
      int newInt = stream.readUnsignedByte();
      if (newInt == 255) {
         newInt = -1;
      }

      this.type = stream.readUnsignedByte();
      if (~(this.type & 128) != -1) {
         this.type &= 127;
         this.aString4765 = stream.readString();
      }

      this.anInt4814 = stream.readUnsignedShort();
      this.anInt4850 = stream.readShort();
      this.anInt4816 = stream.readShort();
      this.anInt4693 = stream.readUnsignedShort();
      this.anInt4722 = stream.readUnsignedShort();
      this.aByte4750 = (byte)stream.readByte();
      this.aByte4741 = (byte)stream.readByte();
      this.aByte4720 = (byte)stream.readByte();
      this.aByte4851 = (byte)stream.readByte();
      this.parentId = stream.readUnsignedShort();
      if (this.parentId != 65535) {
         this.parentId += this.ihash & -65536;
      } else {
         this.parentId = -1;
      }

      int i_17_ = stream.readUnsignedByte();
      this.hidden = ~(1 & i_17_) != -1;
      if (newInt >= 0) {
         this.isHidden = ~(i_17_ & 2) != -1;
      }

      if (this.type == 0) {
         this.anInt4735 = stream.readUnsignedShort();
         this.anInt4691 = stream.readUnsignedShort();
         if (~newInt > -1) {
            this.isHidden = stream.readUnsignedByte() == 1;
         }
      }

      int i_20_;
      if (this.type == 5) {
         this.anInt4820 = stream.readInt();
         this.anInt4728 = stream.readUnsignedShort();
         i_20_ = stream.readUnsignedByte();
         this.aBoolean4861 = ~(i_20_ & 1) != -1;
         this.aBoolean4738 = (i_20_ & 2) != 0;
         this.anInt4757 = stream.readUnsignedByte();
         this.anInt4744 = stream.readUnsignedByte();
         this.anInt4796 = stream.readInt();
         this.aBoolean4732 = stream.readUnsignedByte() == 1;
         this.aBoolean4743 = stream.readUnsignedByte() == 1;
         this.anInt4754 = stream.readInt();
         if (~newInt <= -4) {
            this.aBoolean4782 = ~stream.readUnsignedByte() == -2;
         }
      }

      if (this.type == 6) {
         this.modelType = 1;
         if (this.ihash >> 16 > 1144) {
            this.anInt4864 = stream.readBigSmart();
         } else {
            this.anInt4864 = stream.readUnsignedShort();
            if (~this.anInt4864 == -65536) {
               this.anInt4864 = -1;
            }
         }

         i_20_ = stream.readUnsignedByte();
         this.aBoolean4707 = (4 & i_20_) == 4;
         boolean bool = (1 & i_20_) == 1;
         this.aBoolean4865 = ~(i_20_ & 2) == -3;
         this.aBoolean4727 = ~(8 & i_20_) == -9;
         if (bool) {
            this.anInt4709 = stream.readShort();
            this.anInt4797 = stream.readShort();
            this.anInt4815 = stream.readUnsignedShort();
            this.anInt4821 = stream.readUnsignedShort();
            this.anInt4682 = stream.readUnsignedShort();
            this.anInt4787 = stream.readUnsignedShort();
         } else if (this.aBoolean4865) {
            this.anInt4709 = stream.readShort();
            this.anInt4797 = stream.readShort();
            this.anInt4842 = stream.readShort();
            this.anInt4815 = stream.readUnsignedShort();
            this.anInt4821 = stream.readUnsignedShort();
            this.anInt4682 = stream.readUnsignedShort();
            this.anInt4787 = stream.readShort();
         }

         if (this.ihash >> 16 > 1144) {
            this.anInt4773 = stream.readBigSmart();
         } else {
            this.anInt4773 = stream.readUnsignedShort();
            if (~this.anInt4773 == -65536) {
               this.anInt4773 = -1;
            }
         }

         if (this.aByte4750 != 0) {
            this.anInt4800 = stream.readUnsignedShort();
         }

         if (~this.aByte4741 != -1) {
            this.anInt4849 = stream.readUnsignedShort();
         }
      }

      if (this.type == 4) {
         if (this.ihash >> 16 > 1144) {
            this.anInt4759 = stream.readBigSmart();
         } else {
            this.anInt4759 = stream.readUnsignedShort();
            if (~this.anInt4759 == -65536) {
               this.anInt4759 = -1;
            }
         }

         if (~newInt <= -3) {
            this.aBoolean4832 = ~stream.readUnsignedByte() == -2;
         }

         this.aString4790 = stream.readString();
         this.anInt4697 = stream.readUnsignedByte();
         this.anInt4835 = stream.readUnsignedByte();
         this.anInt4825 = stream.readUnsignedByte();
         this.aBoolean4710 = ~stream.readUnsignedByte() == -2;
         this.anInt4754 = stream.readInt();
         this.anInt4757 = stream.readUnsignedByte();
         if (~newInt <= -1) {
            this.anInt4767 = stream.readUnsignedByte();
         }
      }

      if (~this.type == -4) {
         this.anInt4754 = stream.readInt();
         this.aBoolean4769 = ~stream.readUnsignedByte() == -2;
         this.anInt4757 = stream.readUnsignedByte();
      }

      if (~this.type == -10) {
         this.anInt4752 = stream.readUnsignedByte();
         this.anInt4754 = stream.readInt();
         this.aBoolean4721 = stream.readUnsignedByte() == 1;
      }

      i_20_ = stream.read24BitInt();
      int i_21_ = stream.readUnsignedByte();
      int i_22_;
      if (~i_21_ != -1) {
         this.aByteArray4806 = new byte[11];
         this.aByteArray4733 = new byte[11];

         for(this.anIntArray4705 = new int[11]; i_21_ != 0; i_21_ = stream.readUnsignedByte()) {
            i_22_ = (i_21_ >> 4) - 1;
            i_21_ = stream.readUnsignedByte() | i_21_ << 8;
            i_21_ &= 4095;
            if (i_21_ == 4095) {
               i_21_ = -1;
            }

            byte b_23_ = (byte)stream.readByte();
            if (~b_23_ != -1) {
               this.aBoolean4802 = true;
            }

            byte b_24_ = (byte)stream.readByte();
            this.anIntArray4705[i_22_] = i_21_;
            this.aByteArray4806[i_22_] = b_23_;
            this.aByteArray4733[i_22_] = b_24_;
         }
      }

      this.aString4779 = stream.readString();
      i_22_ = stream.readUnsignedByte();
      int i_26_ = 15 & i_22_;
      int i_28_;
      if (i_26_ > 0) {
         this.aStringArray4686 = new String[i_26_];

         for(i_28_ = 0; ~i_28_ > ~i_26_; ++i_28_) {
            this.aStringArray4686[i_28_] = stream.readString();
         }
      }

      i_28_ = i_22_ >> 4;
      int i_32_;
      int i_33_;
      if (~i_28_ < -1) {
         i_32_ = stream.readUnsignedByte();
         this.anIntArray4863 = new int[i_32_ - -1];

         for(i_33_ = 0; ~i_33_ > ~this.anIntArray4863.length; ++i_33_) {
            this.anIntArray4863[i_33_] = -1;
         }

         this.anIntArray4863[i_32_] = stream.readUnsignedShort();
      }

      if (~i_28_ < -2) {
         i_32_ = stream.readUnsignedByte();
         this.anIntArray4863[i_32_] = stream.readUnsignedShort();
      }

      this.aString4784 = stream.readString();
      if (this.aString4784.equals("")) {
         this.aString4784 = null;
      }

      this.anInt4708 = stream.readUnsignedByte();
      this.anInt4795 = stream.readUnsignedByte();
      this.anInt4860 = stream.readUnsignedByte();
      this.aString4786 = stream.readString();
      i_32_ = -1;
      if (~method925(i_20_) != -1) {
         i_32_ = stream.readUnsignedShort();
         if (i_32_ == 65535) {
            i_32_ = -1;
         }

         this.anInt4698 = stream.readUnsignedShort();
         if (~this.anInt4698 == -65536) {
            this.anInt4698 = -1;
         }

         this.anInt4839 = stream.readUnsignedShort();
         if (this.anInt4839 == 65535) {
            this.anInt4839 = -1;
         }
      }

      if (newInt >= 0) {
         this.anInt4761 = stream.readUnsignedShort();
         if (this.anInt4761 == 65535) {
            this.anInt4761 = -1;
         }
      }

      this.aNode_Sub35_4840 = new IComponentSettings(i_20_, i_32_);
      if (newInt >= 0) {
         i_33_ = stream.readUnsignedByte();

         int i_37_;
         int i_38_;
         int i_39_;
         for(i_37_ = 0; i_33_ > i_37_; ++i_37_) {
            i_38_ = stream.read24BitInt();
            i_39_ = stream.readInt();
            this.aHashTable4823.put((long)i_38_, i_39_);
         }

         i_37_ = stream.readUnsignedByte();

         for(i_38_ = 0; i_38_ < i_37_; ++i_38_) {
            i_39_ = stream.read24BitInt();
            String string = stream.readJagString();
            this.aHashTable4823.put((long)i_39_, string);
         }
      }

      this.anObjectArray4758 = this.decodeScript(stream);
      this.anObjectArray4706 = this.decodeScript(stream);
      this.anObjectArray4818 = this.decodeScript(stream);
      this.anObjectArray4771 = this.decodeScript(stream);
      this.anObjectArray4768 = this.decodeScript(stream);
      this.anObjectArray4807 = this.decodeScript(stream);
      this.anObjectArray4742 = this.decodeScript(stream);
      this.anObjectArray4788 = this.decodeScript(stream);
      this.anObjectArray4701 = this.decodeScript(stream);
      this.anObjectArray4770 = this.decodeScript(stream);
      if (~newInt <= -1) {
         this.anObjectArray4751 = this.decodeScript(stream);
      }

      this.anObjectArray4834 = this.decodeScript(stream);
      this.anObjectArray4774 = this.decodeScript(stream);
      this.anObjectArray4803 = this.decodeScript(stream);
      this.anObjectArray4680 = this.decodeScript(stream);
      this.anObjectArray4856 = this.decodeScript(stream);
      this.anObjectArray4852 = this.decodeScript(stream);
      this.anObjectArray4711 = this.decodeScript(stream);
      this.anObjectArray4753 = this.decodeScript(stream);
      this.anObjectArray4688 = this.decodeScript(stream);
      this.anObjectArray4775 = this.decodeScript(stream);
      this.anIntArray4838 = this.method4150(stream);
      this.anIntArray4833 = this.method4150(stream);
      this.anIntArray4789 = this.method4150(stream);
      this.anIntArray4829 = this.method4150(stream);
      this.anIntArray4805 = this.method4150(stream);
   }

   private final Object[] decodeScript(InputStream buffer) {
      int i = buffer.readUnsignedByte();
      if (~i == -1) {
         return null;
      } else {
         Object[] objects = new Object[i];

         for(int i_3_ = 0; i > i_3_; ++i_3_) {
            int i_4_ = buffer.readUnsignedByte();
            if (i_4_ == 0) {
               objects[i_3_] = new Integer(buffer.readInt());
            } else if (~i_4_ == -2) {
               objects[i_3_] = buffer.readString();
            }
         }

         this.hasScripts = true;
         return objects;
      }
   }

   private final int[] method4150(InputStream buffer) {
      int i = buffer.readUnsignedByte();
      if (i == 0) {
         return null;
      } else {
         int[] is = new int[i];

         for(int i_60_ = 0; i_60_ < i; ++i_60_) {
            is[i_60_] = buffer.readInt();
         }

         return is;
      }
   }

   static final int method925(int i) {
      return (i & 261544) >> 11;
   }

   public IComponentDefinitions() {
      this.aNode_Sub35_4840 = GLOBAL_SETTINGS;
      this.anInt4814 = 0;
      this.anInt4811 = 0;
      this.anInt4722 = 0;
      this.anInt4849 = 0;
      this.anInt4683 = -1;
      this.parentId = -1;
      this.anInt4801 = 0;
      this.anInt4824 = -1;
      this.aWidget4836 = null;
      this.anInt4703 = -1;
      this.isHidden = false;
      this.hidden = false;
      this.anInt4850 = 0;
      this.aBoolean4861 = false;
      this.anInt4848 = -1;
      this.anInt4797 = 0;
      this.anInt4860 = 0;
      this.aBoolean4723 = false;
      this.aByte4851 = 0;
      this.anInt4816 = 0;
      this.anInt4842 = 0;
      this.anInt4839 = -1;
   }
}
