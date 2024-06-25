package jagdx;

import jaclib.peer.os;
import jaclib.peer.ti;

public class D3DLIGHT extends os {
   public final native void SetSpotParams(float var1, float var2, float var3);

   public final native void SetPosition(float var1, float var2, float var3);

   public D3DLIGHT(ti var_ti) {
      super(var_ti);
      this.Init();
   }

   public final native void SetRange(float var1);

   public final native void SetSpecular(float var1, float var2, float var3, float var4);

   private final native void Init();

   public final native void SetDiffuse(float var1, float var2, float var3, float var4);

   public final native void SetType(int var1);

   public final native void SetAttenuation(float var1, float var2, float var3);

   public final native void SetAmbient(float var1, float var2, float var3, float var4);

   public final native void SetDirection(float var1, float var2, float var3);
}
