import com.ms.com.ComFailException;
import com.ms.directX.DSBufferDesc;
import com.ms.directX.DSCursors;
import com.ms.directX.DirectSound;
import com.ms.directX.DirectSoundBuffer;
import com.ms.directX.WaveFormatEx;
import java.awt.Component;

public class Class149 implements Interface5 {
   private int anInt5022;
   private WaveFormatEx aWaveFormatEx5023;
   private DSBufferDesc[] aDSBufferDescArray5024 = new DSBufferDesc[2];
   private int[] anIntArray5025;
   private boolean[] aBooleanArray5026 = new boolean[2];
   private int anInt5027;
   private int anInt5028;
   private int[] anIntArray5029;
   private DirectSound aDirectSound5030;
   private DSCursors[] aDSCursorsArray5031 = new DSCursors[2];
   private int[] anIntArray5032;
   private DirectSoundBuffer[] aDirectSoundBufferArray5033;
   private byte[][] aByteArrayArray5034;

   @Override
   public final void method16(int i, int[] is) {
      int i_0_ = is.length;
      if (i_0_ != 256 * this.anInt5028) {
         throw new IllegalArgumentException();
      } else {
         int i_1_ = this.anIntArray5025[i] * this.anInt5027;

         for(int i_2_ = 0; i_2_ < i_0_; ++i_2_) {
            int i_3_ = is[i_2_];
            if ((i_3_ + 8388608 & 0xFF000000) != 0) {
               i_3_ = 8388607 ^ i_3_ >> 31;
            }

            this.aByteArrayArray5034[i][i_1_ + i_2_ * 2] = (byte)(i_3_ >> 8);
            this.aByteArrayArray5034[i][i_1_ + i_2_ * 2 + 1] = (byte)(i_3_ >> 16);
         }

         this.aDirectSoundBufferArray5033[i].writeBuffer(i_1_, i_0_ * 2, this.aByteArrayArray5034[i], 0);
         this.anIntArray5025[i] = this.anIntArray5025[i] + i_0_ / this.anInt5028 & 65535;
         if (!this.aBooleanArray5026[i]) {
            this.aDirectSoundBufferArray5033[i].play(1);
            this.aBooleanArray5026[i] = true;
         }
      }
   }

   @Override
   public final int method12(int i, int i_4_) {
      if (!this.aBooleanArray5026[i]) {
         return 0;
      } else {
         this.aDirectSoundBufferArray5033[i].getCurrentPosition(this.aDSCursorsArray5031[i]);
         int i_5_ = this.aDSCursorsArray5031[i].write / this.anInt5027;
         int i_6_ = 65535 & this.anIntArray5025[i] + -i_5_;
         if (i_4_ <= 60) {
            this.method15(38, (byte)-82);
         }

         if (~this.anIntArray5032[i] > ~i_6_) {
            int i_7_ = i_5_ - this.anIntArray5025[i] & 65535;

            while(~i_7_ < -1) {
               i_7_ -= 256;
               this.method16(i, this.anIntArray5029);
            }

            i_6_ = 65535 & this.anIntArray5025[i] - i_5_;
         }

         return i_6_;
      }
   }

   @Override
   public final void method14(int i, boolean bool, Component component, byte b) throws Exception {
      if (this.anInt5022 == 0) {
         if (i < 8000 || i > 48000) {
            throw new IllegalArgumentException();
         }

         this.anInt5028 = !bool ? 1 : 2;
         this.anInt5027 = bool ? 4 : 2;
         this.anIntArray5029 = new int[this.anInt5028 * 256];
         this.aDirectSound5030.initialize(null);
         if (b >= -99) {
            this.method17(-83, false);
         }

         this.aDirectSound5030.setCooperativeLevel(component, 2);

         for(int i_8_ = 0; ~i_8_ > -3; ++i_8_) {
            this.aDSBufferDescArray5024[i_8_].flags = 16384;
         }

         this.aWaveFormatEx5023.avgBytesPerSec = i * this.anInt5027;
         this.aWaveFormatEx5023.formatTag = 1;
         this.aWaveFormatEx5023.channels = this.anInt5028;
         this.aWaveFormatEx5023.blockAlign = this.anInt5027;
         this.aWaveFormatEx5023.samplesPerSec = i;
         this.anInt5022 = i;
         this.aWaveFormatEx5023.bitsPerSample = 16;
      }
   }

   @Override
   public final void method17(int i, boolean bool) {
      if (this.aDirectSoundBufferArray5033[i] != null) {
         try {
            this.aDirectSoundBufferArray5033[i].stop();
         } catch (ComFailException var4) {
         }

         this.aDirectSoundBufferArray5033[i] = null;
      }

      if (!bool) {
         this.anIntArray5032 = null;
      }
   }

   @Override
   public final void method13(int i, int i_9_, int i_10_) throws Exception {
      if (~this.anInt5022 != -1 && this.aDirectSoundBufferArray5033[i_9_] == null) {
         int i_11_ = this.anInt5027 * 65536;
         if (this.aByteArrayArray5034[i_9_] == null || ~this.aByteArrayArray5034[i_9_].length != ~i_11_) {
            this.aByteArrayArray5034[i_9_] = new byte[i_11_];
            this.aDSBufferDescArray5024[i_9_].bufferBytes = i_11_;
         }

         if (i_10_ != 65535) {
            this.aDirectSound5030 = null;
         }

         this.aDirectSoundBufferArray5033[i_9_] = this.aDirectSound5030.createSoundBuffer(this.aDSBufferDescArray5024[i_9_], this.aWaveFormatEx5023);
         this.aBooleanArray5026[i_9_] = false;
         this.anIntArray5025[i_9_] = 0;
         this.anIntArray5032[i_9_] = i;
      } else {
         throw new IllegalStateException();
      }
   }

   @Override
   public final void method15(int i, byte b) {
      if (b < 73) {
         this.method16(70, null);
      }

      try {
         this.aDirectSoundBufferArray5033[i].stop();
      } catch (ComFailException var4) {
         var4.printStackTrace();
      }

      this.aBooleanArray5026[i] = false;
      this.aDirectSoundBufferArray5033[i].setCurrentPosition(0);
      this.anIntArray5025[i] = 0;
   }

   public Class149() throws Exception {
      this.anIntArray5025 = new int[2];
      this.aDirectSoundBufferArray5033 = new DirectSoundBuffer[2];
      this.anIntArray5032 = new int[2];
      this.aByteArrayArray5034 = new byte[2][];
      this.aDirectSound5030 = new DirectSound();
      this.aWaveFormatEx5023 = new WaveFormatEx();

      for(int i = 0; ~i > -3; ++i) {
         this.aDSBufferDescArray5024[i] = new DSBufferDesc();
      }

      for(int i = 0; i < 2; ++i) {
         this.aDSCursorsArray5031[i] = new DSCursors();
      }
   }
}
