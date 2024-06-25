class Class200 {
   private GLToolkit aGLToolkit2439;
   protected jaclib.memory.Buffer aBuffer2440;

   final void method2012(byte[] bs, int i) {
      if (this.aBuffer2440 == null || this.aBuffer2440.getSize() < i) {
         this.aBuffer2440 = this.aGLToolkit2439.aNativeHeap6609.a(i, false);
      }

      this.aBuffer2440.a(bs, 0, 0, i);
   }

   Class200(GLToolkit gltoolkit, byte[] bs, int i) {
      this.aGLToolkit2439 = gltoolkit;
      this.aBuffer2440 = this.aGLToolkit2439.aNativeHeap6609.a(i, false);
      if (bs != null) {
         this.aBuffer2440.a(bs, 0, 0, i);
      }
   }

   Class200(GLToolkit gltoolkit, jaclib.memory.Buffer buffer) {
      this.aGLToolkit2439 = gltoolkit;
      this.aBuffer2440 = buffer;
   }
}
