import java.awt.Component;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;

public class Class42_Sub1 extends Class42 {
   private SourceDataLine aSourceDataLine5551;
   private byte[] aByteArray5552;
   private int anInt5553;
   private boolean aBoolean5554 = false;
   private AudioFormat anAudioFormat5555;
   static Class aClass5556;

   @Override
   final void method442() throws LineUnavailableException {
      this.aSourceDataLine5551.flush();
      if (this.aBoolean5554) {
         this.aSourceDataLine5551.close();
         this.aSourceDataLine5551 = null;
         Info info = new Info(
            aClass5556 == null ? (aClass5556 = method456("javax.sound.sampled.SourceDataLine")) : aClass5556,
            this.anAudioFormat5555,
            this.anInt5553 << (!DrawableModel.aBoolean913 ? 1 : 2)
         );
         this.aSourceDataLine5551 = (SourceDataLine)AudioSystem.getLine(info);
         this.aSourceDataLine5551.open();
         this.aSourceDataLine5551.start();
      }
   }

   @Override
   final void method449() {
      int i = 256;
      if (DrawableModel.aBoolean913) {
         i <<= 1;
      }

      for(int i_0_ = 0; i_0_ < i; ++i_0_) {
         int i_1_ = this.anIntArray642[i_0_];
         if ((i_1_ + 8388608 & 0xFF000000) != 0) {
            i_1_ = 8388607 ^ i_1_ >> 31;
         }

         this.aByteArray5552[i_0_ * 2] = (byte)(i_1_ >> 8);
         this.aByteArray5552[i_0_ * 2 + 1] = (byte)(i_1_ >> 16);
      }

      this.aSourceDataLine5551.write(this.aByteArray5552, 0, i << 1);
   }

   @Override
   final void method447(int i) throws LineUnavailableException {
      try {
         Info info = new Info(
            aClass5556 == null ? (aClass5556 = method456("javax.sound.sampled.SourceDataLine")) : aClass5556,
            this.anAudioFormat5555,
            i << (!DrawableModel.aBoolean913 ? 1 : 2)
         );
         this.aSourceDataLine5551 = (SourceDataLine)AudioSystem.getLine(info);
         this.aSourceDataLine5551.open();
         this.aSourceDataLine5551.start();
         this.anInt5553 = i;
      } catch (LineUnavailableException var3) {
         if (1 == Node_Sub12.method2545(i, 858993459)) {
            this.aSourceDataLine5551 = null;
            throw var3;
         }

         this.method447(Class320_Sub19.method3753(i));
      }
   }

   @Override
   final void method455() {
      if (this.aSourceDataLine5551 != null) {
         this.aSourceDataLine5551.close();
         this.aSourceDataLine5551 = null;
      }
   }

   Class42_Sub1() {
   }

   @Override
   final int method446() {
      return this.anInt5553 - (this.aSourceDataLine5551.available() >> (!DrawableModel.aBoolean913 ? 1 : 2));
   }

   @Override
   final void method452(Component component) {
      javax.sound.sampled.Mixer.Info[] infos = AudioSystem.getMixerInfo();
      if (infos != null) {
         javax.sound.sampled.Mixer.Info[] infos_2_ = infos;

         for(int i = 0; ~i > ~infos_2_.length; ++i) {
            javax.sound.sampled.Mixer.Info info = infos_2_[i];
            if (info != null) {
               String string = info.getName();
               if (string != null && ~string.toLowerCase().indexOf("soundmax") <= -1) {
                  this.aBoolean5554 = true;
               }
            }
         }
      }

      this.anAudioFormat5555 = new AudioFormat((float)Class365.anInt4523, 16, !DrawableModel.aBoolean913 ? 1 : 2, true, false);
      this.aByteArray5552 = new byte[256 << (DrawableModel.aBoolean913 ? 2 : 1)];
   }

   static Class method456(String string) {
      try {
         return Class.forName(string);
      } catch (ClassNotFoundException var3) {
         throw (NoClassDefFoundError)new NoClassDefFoundError().initCause(var3);
      }
   }
}
