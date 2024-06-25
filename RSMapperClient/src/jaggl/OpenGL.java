package jaggl;

import java.util.Hashtable;

public class OpenGL {
   private static Hashtable<Thread, OpenGL> a = new Hashtable<>();
   protected long peer;
   private Hashtable<String, String> c;
   private Thread b;

   public static final native void glPixelZoom(float var0, float var1);

   public final native void release();

   public static final native void glUniform1iARB(int var0, int var1);

   public static final native void glColor3f(float var0, float var1, float var2);

   public final native long init(java.awt.Canvas var1, int var2, int var3, int var4, int var5, int var6, int var7);

   public static final native void glBufferDataARBa(int var0, int var1, long var2, int var4);

   public static final native void glMultiTexCoord2i(int var0, int var1, int var2);

   public static final native void glTexCoord3f(float var0, float var1, float var2);

   public static final native void glReadPixelsi(int var0, int var1, int var2, int var3, int var4, int var5, int[] var6, int var7);

   public static final native void glRasterPos2i(int var0, int var1);

   public static final native void glNormal3f(float var0, float var1, float var2);

   public static final native void glGetTexImageub(int var0, int var1, int var2, int var3, byte[] var4, int var5);

   public static final native long glCreateProgramObjectARB();

   public static final native void glVertexPointer(int var0, int var1, int var2, long var3);

   public static final native void glShaderSourceARB(long var0, String var2);

   public static final native void glProgramStringARB(int var0, int var1, String var2);

   public static final native void glGetProgramivARB(int var0, int var1, int[] var2, int var3);

   public static final native void glGenFramebuffersEXT(int var0, int[] var1, int var2);

   public static final native void glTexParameteri(int var0, int var1, int var2);

   public static final native void glDeleteBuffersARB(int var0, int[] var1, int var2);

   public static final native void glDisable(int var0);

   public final native void surfaceResized(long var1);

   public static final native void glTexSubImage2Di(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int[] var8, int var9);

   public static final native void glGenBuffersARB(int var0, int[] var1, int var2);

   public static final native void glTexImage2Dub(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, byte[] var8, int var9);

   public static final native void glGetInfoLogARB(long var0, int var2, int[] var3, int var4, byte[] var5, int var6);

   public static final native void glColor4ub(byte var0, byte var1, byte var2, byte var3);

   public final boolean a(String string) {
      if (this.c == null) {
         this.c = new Hashtable<>();
         String string_59_ = glGetString(7939);
         int i = 0;

         while (true) {
            int i_60_ = string_59_.indexOf(32, i);
            if (i_60_ == -1) {
               String string_62_ = string_59_.substring(i).trim();
               if (~string_62_.length() != -1) {
                  this.c.put(string_62_, string_62_);
               }
               break;
            }

            String string_61_ = string_59_.substring(i, i_60_).trim();
            if (string_61_.length() != 0) {
               this.c.put(string_61_, string_61_);
            }

            i = i_60_ - -1;
         }
      }

      return this.c.containsKey(string);
   }

   public static final native void glUniform1fARB(int var0, float var1);

   public static final native void glVertex3f(float var0, float var1, float var2);

   public static final native void glTexCoord2f(float var0, float var1);

   public static final native void glDeleteObjectARB(long var0);

   public final native void setPbuffer(long var1);

   public static final native void glDetachObjectARB(long var0, long var2);

   public static final native void glColor4f(float var0, float var1, float var2, float var3);

   public static final native void glTexImage3Dub(
      int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, byte[] var9, int var10
   );

   static final native long glMapBufferARB(int var0, int var1);

   public static final native void glEnable(int var0);

   public static final native void glLinkProgramARB(long var0);

   public static final native void glFramebufferRenderbufferEXT(int var0, int var1, int var2, int var3);

   public static final native void glColorMask(boolean var0, boolean var1, boolean var2, boolean var3);

   public static final native void glDrawPixelsub(int var0, int var1, int var2, int var3, byte[] var4, int var5);

   public static final native void glTexImage2Di(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int[] var8, int var9);

   public static final native void glGenRenderbuffersEXT(int var0, int[] var1, int var2);

   public final native void swapBuffers();

   public final native void releaseSurface(java.awt.Canvas var1, long var2);

   public static final native int glGenLists(int var0);

   public static final native void glTexParameterf(int var0, int var1, float var2);

   public static final native void glNewList(int var0, int var1);

   public static final native void glGetObjectParameterivARB(long var0, int var2, int[] var3, int var4);

   public static final native void glUseProgramObjectARB(long var0);

   public static final native void glEnd();

   public static final native void glDrawBuffer(int var0);

   public static final native long glCreateShaderObjectARB(int var0);

   public static final native void glGetIntegerv(int var0, int[] var1, int var2);

   public static final native void glColorMaterial(int var0, int var1);

   public final native long prepareSurface(java.awt.Canvas var1);

   public static final native void glGetTexImagei(int var0, int var1, int var2, int var3, int[] var4, int var5);

   public static final native void glUniformMatrix4fvARB(int var0, int var1, boolean var2, float[] var3, int var4);

   public static final native void glDepthFunc(int var0);

   public final native long createPbuffer(int var1, int var2);

   public static final native void glDeleteTextures(int var0, int[] var1, int var2);

   public static final native void glColorPointer(int var0, int var1, int var2, long var3);

   public final native boolean setSurface(long var1);

   public static final native void glFlush();

   public static final native void glTexCoord2i(int var0, int var1);

   public static final native void glProgramLocalParameter4fARB(int var0, int var1, float var2, float var3, float var4, float var5);

   public static final native void glDrawArrays(int var0, int var1, int var2);

   public static final native void glBlitFramebufferEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9);

   public static final native void glDrawPixelsi(int var0, int var1, int var2, int var3, int[] var4, int var5);

   public static final native void glTexImage1Dub(int var0, int var1, int var2, int var3, int var4, int var5, int var6, byte[] var7, int var8);

   public static final native void glAttachObjectARB(long var0, long var2);

   public static final native void glMultMatrixf(float[] var0, int var1);

   public static final native int glGetError();

   public final synchronized boolean b() {
      Thread thread = Thread.currentThread();
      if (this.attachPeer()) {
         OpenGL opengl_142_ = a.put(thread, this);
         if (opengl_142_ != null) {
            opengl_142_.b = null;
         }

         this.b = thread;
         return true;
      } else {
         return false;
      }
   }

   public static final native void glFramebufferTexture3DEXT(int var0, int var1, int var2, int var3, int var4, int var5);

   public static final native void glRotatef(float var0, float var1, float var2, float var3);

   public static final native void glPushAttrib(int var0);

   public static final native void glGenerateMipmapEXT(int var0);

   public static final native void glViewport(int var0, int var1, int var2, int var3);

   public static final native void glGenTextures(int var0, int[] var1, int var2);

   public static final native void glBindFramebufferEXT(int var0, int var1);

   public final synchronized boolean a() {
      if (this.b != Thread.currentThread()) {
         return false;
      } else {
         this.detachPeer();
         a.remove(this.b);
         this.b = null;
         return true;
      }
   }

   public static final native void glPopAttrib();

   public static final native void glDeleteProgramARB(int var0);

   public static final native void glClientActiveTexture(int var0);

   public static final native void glLightModelfv(int var0, float[] var1, int var2);

   public static final native void glBindRenderbufferEXT(int var0, int var1);

   public static final native void glDepthMask(boolean var0);

   public static final native void glTexSubImage2Dub(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, byte[] var8, int var9);

   public static final native void glMatrixMode(int var0);

   public static final native void glBufferDataARBub(int var0, int var1, byte[] var2, int var3, int var4);

   public static final native void glBindBufferARB(int var0, int var1);

   public static final native void glMaterialfv(int var0, int var1, float[] var2, int var3);

   public static final native void glLoadIdentity();

   public static final native void glPixelStorei(int var0, int var1);

   public static final native void glMultiTexCoord2f(int var0, float var1, float var2);

   public static final native void glGetFloatv(int var0, float[] var1, int var2);

   public static final native void glPolygonMode(int var0, int var1);

   public static final native void glPointSize(float var0);

   public static final native void glRenderbufferStorageEXT(int var0, int var1, int var2, int var3);

   public static final native void glFinish();

   public static final native void glScalef(float var0, float var1, float var2);

   public static final native void glCullFace(int var0);

   public static final native void glShaderSourceRawARB(long var0, byte[] var2);

   public static final native void glTexEnvfv(int var0, int var1, float[] var2, int var3);

   public static final native void glPixelTransferf(int var0, float var1);

   public static final native void glMultiTexCoord3i(int var0, int var1, int var2, int var3);

   public static final native void glCallList(int var0);

   public static final native void glUniformMatrix3fvARB(int var0, int var1, boolean var2, float[] var3, int var4);

   public static final native void glBindProgramARB(int var0, int var1);

   public final native void releasePbuffer(long var1);

   public static final native void glTexEnvi(int var0, int var1, int var2);

   public static final native void glEndList();

   public static final native void glCompileShaderARB(long var0);

   public static final native void glCopyPixels(int var0, int var1, int var2, int var3, int var4);

   public static final native void glTexImage2Df(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, float[] var8, int var9);

   static final native boolean glUnmapBufferARB(int var0);

   public static final native void glClearDepth(float var0);

   public static final native void glVertex2i(int var0, int var1);

   public static final native void glClearColor(float var0, float var1, float var2, float var3);

   public static final native void glPushMatrix();

   public static final native void glActiveTexture(int var0);

   public static final native void glTexSubImage2Df(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, float[] var8, int var9);

   public static final native void glScissor(int var0, int var1, int var2, int var3);

   public static final native void glColor3ub(byte var0, byte var1, byte var2);

   public static final native void glClear(int var0);

   public static final native void glDeleteLists(int var0, int var1);

   public static final native int glGenProgramARB();

   public static final native void glFogfv(int var0, float[] var1, int var2);

   public static final native void glProgramRawARB(int var0, int var1, byte[] var2);

   public static final native void glTexGenfv(int var0, int var1, float[] var2, int var3);

   public static final native void glFramebufferTexture2DEXT(int var0, int var1, int var2, int var3, int var4);

   public static final native void glUniform4fARB(int var0, float var1, float var2, float var3, float var4);

   public static final native void glLightfv(int var0, int var1, float[] var2, int var3);

   public static final native void glTexGeni(int var0, int var1, int var2);

   public static final native void glDrawBuffersARB(int var0, int[] var1, int var2);

   public static final native void glLineWidth(float var0);

   public static final native String glGetString(int var0);

   public static final native void glTexCoordPointer(int var0, int var1, int var2, long var3);

   public static final native void glShadeModel(int var0);

   public static final native void glLoadMatrixf(float[] var0, int var1);

   public static final native void glBlendFunc(int var0, int var1);

   public static final native int glGetUniformLocationARB(long var0, String var2);

   public static final native int glCheckFramebufferStatusEXT(int var0);

   public static final native void glUniform3fARB(int var0, float var1, float var2, float var3);

   public static final native void glDrawElements(int var0, int var1, int var2, long var3);

   public static final native void glFogf(int var0, float var1);

   public static final native void glTexEnvf(int var0, int var1, float var2);

   public static final native void glRenderbufferStorageMultisampleEXT(int var0, int var1, int var2, int var3, int var4);

   public static final native void glCopyTexSubImage3D(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8);

   public static final native void glFrustum(double var0, double var2, double var4, double var6, double var8, double var10);

   public static final native void glUniform2fARB(int var0, float var1, float var2);

   private final native void detachPeer();

   public static final native void glDeleteFramebuffersEXT(int var0, int[] var1, int var2);

   public static final native void glUniformMatrix2fvARB(int var0, int var1, boolean var2, float[] var3, int var4);

   public static final native void glCopyTexSubImage2D(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7);

   public static final native void glCopyTexImage2D(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7);

   public static final native void glOrtho(double var0, double var2, double var4, double var6, double var8, double var10);

   public static final native void glBufferSubDataARBub(int var0, int var1, int var2, byte[] var3, int var4);

   public static final native void glTexCoord3i(int var0, int var1, int var2);

   public static final native void glTranslatef(float var0, float var1, float var2);

   public static final native void glPopMatrix();

   public static final native void glStencilFunc(int var0, int var1, int var2);

   private final native boolean attachPeer();

   public static final native void glBegin(int var0);

   public static final native void glBindTexture(int var0, int var1);

   public static final native void glReadBuffer(int var0);

   public final native void setSwapInterval(int var1);

   public final native boolean arePbuffersAvailable();

   public static final native void glReadPixelsub(int var0, int var1, int var2, int var3, int var4, int var5, byte[] var6, int var7);

   public static final native void glDeleteRenderbuffersEXT(int var0, int[] var1, int var2);

   public static final native void glLightf(int var0, int var1, float var2);

   public static final native void glEnableClientState(int var0);

   public static final native void glHint(int var0, int var1);

   public static final native void glNormalPointer(int var0, int var1, long var2);

   public static final native void glAlphaFunc(int var0, float var1);

   public static final native void glProgramLocalParameter4fvARB(int var0, int var1, float[] var2, int var3);

   public static final native void glVertex2f(float var0, float var1);

   public static final native void glStencilOp(int var0, int var1, int var2);

   public static final native void glBufferSubDataARBa(int var0, int var1, int var2, long var3);

   public static final native void glDisableClientState(int var0);

   public static final native void glFogi(int var0, int var1);
}
