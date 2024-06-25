import java.util.HashMap;
import java.util.Map;

public enum Shape {
   ONE(
      new java.awt.Point[][]{
         {new java.awt.Point(0, 2), new java.awt.Point(2, 0)},
         {new java.awt.Point(0, 0), new java.awt.Point(2, 2)},
         {new java.awt.Point(0, 2), new java.awt.Point(2, 0)},
         {new java.awt.Point(0, 0), new java.awt.Point(2, 2)}
      }
   ),
   TWO(
      new java.awt.Point[][]{
         {new java.awt.Point(0, 0), new java.awt.Point(1, 2)},
         {new java.awt.Point(0, 2), new java.awt.Point(2, 1)},
         {new java.awt.Point(1, 0), new java.awt.Point(2, 2)},
         {new java.awt.Point(0, 1), new java.awt.Point(2, 0)}
      }
   ),
   THREE(
      new java.awt.Point[][]{
         {new java.awt.Point(2, 0), new java.awt.Point(1, 2)},
         {new java.awt.Point(0, 0), new java.awt.Point(2, 1)},
         {new java.awt.Point(0, 2), new java.awt.Point(1, 0)},
         {new java.awt.Point(0, 1), new java.awt.Point(2, 2)}
      }
   ),
   FOUR(
      new java.awt.Point[][]{
         {new java.awt.Point(0, 0), new java.awt.Point(1, 2)},
         {new java.awt.Point(0, 2), new java.awt.Point(2, 1)},
         {new java.awt.Point(1, 0), new java.awt.Point(2, 2)},
         {new java.awt.Point(0, 1), new java.awt.Point(2, 0)}
      }
   ),
   FIVE(
      new java.awt.Point[][]{
         {new java.awt.Point(1, 2), new java.awt.Point(2, 0)},
         {new java.awt.Point(0, 0), new java.awt.Point(2, 1)},
         {new java.awt.Point(0, 2), new java.awt.Point(1, 0)},
         {new java.awt.Point(0, 1), new java.awt.Point(2, 2)}
      }
   ),
   SIX(
      new java.awt.Point[][]{
         {new java.awt.Point(1, 0), new java.awt.Point(1, 2)},
         {new java.awt.Point(0, 1), new java.awt.Point(2, 1)},
         {new java.awt.Point(1, 0), new java.awt.Point(1, 2)},
         {new java.awt.Point(0, 1), new java.awt.Point(2, 1)}
      }
   ),
   SEVEN(
      new java.awt.Point[][]{
         {new java.awt.Point(0, 1), new java.awt.Point(1, 0)},
         {new java.awt.Point(0, 1), new java.awt.Point(1, 2)},
         {new java.awt.Point(1, 2), new java.awt.Point(2, 1)},
         {new java.awt.Point(1, 0), new java.awt.Point(2, 1)}
      }
   ),
   EIGHT(
      new java.awt.Point[][]{
         {new java.awt.Point(0, 1), new java.awt.Point(1, 0)},
         {new java.awt.Point(0, 1), new java.awt.Point(1, 2)},
         {new java.awt.Point(1, 2), new java.awt.Point(2, 1)},
         {new java.awt.Point(1, 0), new java.awt.Point(2, 1)}
      }
   ),
   NINE(
      new java.awt.Point[][]{
         {new java.awt.Point(0, 0), new java.awt.Point(2, 2)},
         {new java.awt.Point(0, 2), new java.awt.Point(2, 0)},
         {new java.awt.Point(0, 0), new java.awt.Point(2, 2)},
         {new java.awt.Point(0, 2), new java.awt.Point(2, 0)}
      }
   ),
   TEN(
      new java.awt.Point[][]{
         {new java.awt.Point(0, 0), new java.awt.Point(2, 2)},
         {new java.awt.Point(0, 2), new java.awt.Point(2, 0)},
         {new java.awt.Point(0, 0), new java.awt.Point(2, 2)},
         {new java.awt.Point(0, 2), new java.awt.Point(2, 0)}
      }
   );

   private static Map<Integer, Shape> shapes = new HashMap<>();
   private int shapeValue = this.ordinal() + 1;
   java.awt.Point[][] pointsByRotation;

   static {
      Shape[] var3;
      for(Shape shape : var3 = values()) {
         shapes.put(shape.ordinal() + 1, shape);
      }
   }

   public static Shape getShapeFromPoints(java.awt.Point point1, java.awt.Point point2, boolean reversed) {
      if ((point1.x != 0 || point1.y != 0) && (point2.x != 0 || point2.y != 0)) {
         if ((point1.x != 0 || point1.y != 1) && (point2.x != 0 || point2.y != 1)) {
            if ((point1.x != 0 || point1.y != 2) && (point2.x != 0 || point2.y != 2)) {
               if ((point1.x != 1 || point1.y != 2) && (point2.x != 1 || point2.y != 2)) {
                  if ((point1.x != 2 || point1.y != 2) && (point2.x != 2 || point2.y != 2)) {
                     if ((point1.x != 2 || point1.y != 1) && (point2.x != 2 || point2.y != 1)) {
                        if ((point1.x != 2 || point1.y != 0) && (point2.x != 2 || point2.y != 0)) {
                           if (point1.x == 1 && point1.y == 0 || point2.x == 1 && point2.y == 0) {
                              boolean basePoint1 = point1.x == 1 && point1.y == 0;
                              if ((basePoint1 ? point2.x : point1.x) == 0 && (basePoint1 ? point2.y : point1.y) == 1) {
                                 return reversed ? shapes.get(8) : shapes.get(7);
                              }

                              if ((basePoint1 ? point2.x : point1.x) == 0 && (basePoint1 ? point2.y : point1.y) == 2) {
                                 return reversed ? shapes.get(5) : shapes.get(3);
                              }

                              if ((basePoint1 ? point2.x : point1.x) == 1 && (basePoint1 ? point2.y : point1.y) == 2) {
                                 return shapes.get(6);
                              }

                              if ((basePoint1 ? point2.x : point1.x) == 2 && (basePoint1 ? point2.y : point1.y) == 2) {
                                 return reversed ? shapes.get(4) : shapes.get(2);
                              }

                              if ((basePoint1 ? point2.x : point1.x) == 2 && (basePoint1 ? point2.y : point1.y) == 1) {
                                 return reversed ? shapes.get(8) : shapes.get(7);
                              }
                           }
                        } else {
                           boolean basePoint1 = point1.x == 2 && point1.y == 0;
                           if ((basePoint1 ? point2.x : point1.x) == 0 && (basePoint1 ? point2.y : point1.y) == 2) {
                              return shapes.get(1);
                           }

                           if ((basePoint1 ? point2.x : point1.x) == 0 && (basePoint1 ? point2.y : point1.y) == 1) {
                              return reversed ? shapes.get(4) : shapes.get(2);
                           }

                           if ((basePoint1 ? point2.x : point1.x) == 1 && (basePoint1 ? point2.y : point1.y) == 2) {
                              return reversed ? shapes.get(5) : shapes.get(3);
                           }
                        }
                     } else {
                        boolean basePoint1 = point1.x == 2 && point1.y == 1;
                        if ((basePoint1 ? point2.x : point1.x) == 1 && (basePoint1 ? point2.y : point1.y) == 0) {
                           return reversed ? shapes.get(8) : shapes.get(7);
                        }

                        if ((basePoint1 ? point2.x : point1.x) == 0 && (basePoint1 ? point2.y : point1.y) == 2) {
                           return reversed ? shapes.get(2) : shapes.get(4);
                        }

                        if ((basePoint1 ? point2.x : point1.x) == 1 && (basePoint1 ? point2.y : point1.y) == 0) {
                           return shapes.get(6);
                        }

                        if ((basePoint1 ? point2.x : point1.x) == 0 && (basePoint1 ? point2.y : point1.y) == 0) {
                           return reversed ? shapes.get(5) : shapes.get(3);
                        }

                        if ((basePoint1 ? point2.x : point1.x) == 1 && (basePoint1 ? point2.y : point1.y) == 2) {
                           return reversed ? shapes.get(8) : shapes.get(7);
                        }
                     }
                  } else {
                     boolean basePoint1 = point1.x == 2 && point1.y == 2;
                     if ((basePoint1 ? point2.x : point1.x) == 0 && (basePoint1 ? point2.y : point1.y) == 0) {
                        return shapes.get(1);
                     }

                     if ((basePoint1 ? point2.x : point1.x) == 0 && (basePoint1 ? point2.y : point1.y) == 1) {
                        return reversed ? shapes.get(5) : shapes.get(3);
                     }

                     if ((basePoint1 ? point2.x : point1.x) == 1 && (basePoint1 ? point2.y : point1.y) == 0) {
                        return reversed ? shapes.get(4) : shapes.get(2);
                     }
                  }
               } else {
                  boolean basePoint1 = point1.x == 1 && point1.y == 2;
                  if ((basePoint1 ? point2.x : point1.x) == 0 && (basePoint1 ? point2.y : point1.y) == 1) {
                     return reversed ? shapes.get(8) : shapes.get(7);
                  }

                  if ((basePoint1 ? point2.x : point1.x) == 2 && (basePoint1 ? point2.y : point1.y) == 0) {
                     return reversed ? shapes.get(5) : shapes.get(3);
                  }

                  if ((basePoint1 ? point2.x : point1.x) == 1 && (basePoint1 ? point2.y : point1.y) == 0) {
                     return shapes.get(6);
                  }

                  if ((basePoint1 ? point2.x : point1.x) == 0 && (basePoint1 ? point2.y : point1.y) == 0) {
                     return reversed ? shapes.get(4) : shapes.get(2);
                  }

                  if ((basePoint1 ? point2.x : point1.x) == 2 && (basePoint1 ? point2.y : point1.y) == 1) {
                     return reversed ? shapes.get(8) : shapes.get(7);
                  }
               }
            } else {
               boolean basePoint1 = point1.x == 0 && point1.y == 2;
               if ((basePoint1 ? point2.x : point1.x) == 2 && (basePoint1 ? point2.y : point1.y) == 1) {
                  return reversed ? shapes.get(4) : shapes.get(2);
               }

               if ((basePoint1 ? point2.x : point1.x) == 2 && (basePoint1 ? point2.y : point1.y) == 0) {
                  return shapes.get(1);
               }

               if ((basePoint1 ? point2.x : point1.x) == 1 && (basePoint1 ? point2.y : point1.y) == 0) {
                  return reversed ? shapes.get(5) : shapes.get(3);
               }
            }
         } else {
            boolean basePoint1 = point1.x == 0 && point1.y == 1;
            if ((basePoint1 ? point2.x : point1.x) == 1 && (basePoint1 ? point2.y : point1.y) == 2) {
               return reversed ? shapes.get(8) : shapes.get(7);
            }

            if ((basePoint1 ? point2.x : point1.x) == 2 && (basePoint1 ? point2.y : point1.y) == 2) {
               return reversed ? shapes.get(5) : shapes.get(3);
            }

            if ((basePoint1 ? point2.x : point1.x) == 2 && (basePoint1 ? point2.y : point1.y) == 1) {
               return shapes.get(6);
            }

            if ((basePoint1 ? point2.x : point1.x) == 2 && (basePoint1 ? point2.y : point1.y) == 0) {
               return reversed ? shapes.get(4) : shapes.get(2);
            }

            if ((basePoint1 ? point2.x : point1.x) == 1 && (basePoint1 ? point2.y : point1.y) == 0) {
               return reversed ? shapes.get(8) : shapes.get(7);
            }
         }
      } else {
         boolean basePoint1 = point1.x == 0 && point1.y == 0;
         if ((basePoint1 ? point2.x : point1.x) == 2 && (basePoint1 ? point2.y : point1.y) == 2) {
            return shapes.get(1);
         }

         if ((basePoint1 ? point2.x : point1.x) == 2 && (basePoint1 ? point2.y : point1.y) == 1) {
            return reversed ? shapes.get(5) : shapes.get(3);
         }

         if ((basePoint1 ? point2.x : point1.x) == 1 && (basePoint1 ? point2.y : point1.y) == 2) {
            return reversed ? shapes.get(4) : shapes.get(2);
         }
      }

      return null;
   }

   public static int getRotationFromPoints(java.awt.Point point1, java.awt.Point point2, boolean reversed) {
      if ((point1.x != 0 || point1.y != 0) && (point2.x != 0 || point2.y != 0)) {
         if ((point1.x != 0 || point1.y != 1) && (point2.x != 0 || point2.y != 1)) {
            if ((point1.x != 0 || point1.y != 2) && (point2.x != 0 || point2.y != 2)) {
               if ((point1.x != 1 || point1.y != 2) && (point2.x != 1 || point2.y != 2)) {
                  if ((point1.x != 2 || point1.y != 2) && (point2.x != 2 || point2.y != 2)) {
                     if ((point1.x != 2 || point1.y != 1) && (point2.x != 2 || point2.y != 1)) {
                        if ((point1.x != 2 || point1.y != 0) && (point2.x != 2 || point2.y != 0)) {
                           if (point1.x == 1 && point1.y == 0 || point2.x == 1 && point2.y == 0) {
                              boolean basePoint1 = point1.x == 1 && point1.y == 0;
                              if ((basePoint1 ? point2.x : point1.x) == 0 && (basePoint1 ? point2.y : point1.y) == 1) {
                                 return 0;
                              }

                              if ((basePoint1 ? point2.x : point1.x) == 0 && (basePoint1 ? point2.y : point1.y) == 2) {
                                 return 2;
                              }

                              if ((basePoint1 ? point2.x : point1.x) == 1 && (basePoint1 ? point2.y : point1.y) == 2) {
                                 return reversed ? 2 : 0;
                              }

                              if ((basePoint1 ? point2.x : point1.x) == 2 && (basePoint1 ? point2.y : point1.y) == 2) {
                                 return 2;
                              }

                              if ((basePoint1 ? point2.x : point1.x) == 2 && (basePoint1 ? point2.y : point1.y) == 1) {
                                 return 3;
                              }
                           }
                        } else {
                           boolean basePoint1 = point1.x == 2 && point1.y == 0;
                           if ((basePoint1 ? point2.x : point1.x) == 0 && (basePoint1 ? point2.y : point1.y) == 2) {
                              return reversed ? 2 : 0;
                           }

                           if ((basePoint1 ? point2.x : point1.x) == 0 && (basePoint1 ? point2.y : point1.y) == 1) {
                              return 3;
                           }

                           if ((basePoint1 ? point2.x : point1.x) == 1 && (basePoint1 ? point2.y : point1.y) == 2) {
                              return 0;
                           }
                        }
                     } else {
                        boolean basePoint1 = point1.x == 2 && point1.y == 1;
                        if ((basePoint1 ? point2.x : point1.x) == 1 && (basePoint1 ? point2.y : point1.y) == 0) {
                           return 3;
                        }

                        if ((basePoint1 ? point2.x : point1.x) == 0 && (basePoint1 ? point2.y : point1.y) == 2) {
                           return 1;
                        }

                        if ((basePoint1 ? point2.x : point1.x) == 1 && (basePoint1 ? point2.y : point1.y) == 0) {
                           return reversed ? 3 : 1;
                        }

                        if ((basePoint1 ? point2.x : point1.x) == 0 && (basePoint1 ? point2.y : point1.y) == 0) {
                           return 1;
                        }

                        if ((basePoint1 ? point2.x : point1.x) == 1 && (basePoint1 ? point2.y : point1.y) == 2) {
                           return 2;
                        }
                     }
                  } else {
                     boolean basePoint1 = point1.x == 2 && point1.y == 2;
                     if ((basePoint1 ? point2.x : point1.x) == 0 && (basePoint1 ? point2.y : point1.y) == 0) {
                        return reversed ? 3 : 1;
                     }

                     if ((basePoint1 ? point2.x : point1.x) == 0 && (basePoint1 ? point2.y : point1.y) == 1) {
                        return 3;
                     }

                     if ((basePoint1 ? point2.x : point1.x) == 1 && (basePoint1 ? point2.y : point1.y) == 0) {
                        return 2;
                     }
                  }
               } else {
                  boolean basePoint1 = point1.x == 1 && point1.y == 2;
                  if ((basePoint1 ? point2.x : point1.x) == 0 && (basePoint1 ? point2.y : point1.y) == 1) {
                     return 1;
                  }

                  if ((basePoint1 ? point2.x : point1.x) == 2 && (basePoint1 ? point2.y : point1.y) == 0) {
                     return 0;
                  }

                  if ((basePoint1 ? point2.x : point1.x) == 1 && (basePoint1 ? point2.y : point1.y) == 0) {
                     return reversed ? 2 : 0;
                  }

                  if ((basePoint1 ? point2.x : point1.x) == 0 && (basePoint1 ? point2.y : point1.y) == 0) {
                     return 0;
                  }

                  if ((basePoint1 ? point2.x : point1.x) == 2 && (basePoint1 ? point2.y : point1.y) == 1) {
                     return 2;
                  }
               }
            } else {
               boolean basePoint1 = point1.x == 0 && point1.y == 2;
               if ((basePoint1 ? point2.x : point1.x) == 2 && (basePoint1 ? point2.y : point1.y) == 1) {
                  return 1;
               }

               if ((basePoint1 ? point2.x : point1.x) == 2 && (basePoint1 ? point2.y : point1.y) == 0) {
                  return reversed ? 2 : 0;
               }

               if ((basePoint1 ? point2.x : point1.x) == 1 && (basePoint1 ? point2.y : point1.y) == 0) {
                  return 2;
               }
            }
         } else {
            boolean basePoint1 = point1.x == 0 && point1.y == 1;
            if ((basePoint1 ? point2.x : point1.x) == 1 && (basePoint1 ? point2.y : point1.y) == 2) {
               return 1;
            }

            if ((basePoint1 ? point2.x : point1.x) == 2 && (basePoint1 ? point2.y : point1.y) == 2) {
               return 3;
            }

            if ((basePoint1 ? point2.x : point1.x) == 2 && (basePoint1 ? point2.y : point1.y) == 1) {
               return reversed ? 3 : 1;
            }

            if ((basePoint1 ? point2.x : point1.x) == 2 && (basePoint1 ? point2.y : point1.y) == 0) {
               return 3;
            }

            if ((basePoint1 ? point2.x : point1.x) == 1 && (basePoint1 ? point2.y : point1.y) == 0) {
               return 0;
            }
         }
      } else {
         boolean basePoint1 = point1.x == 0 && point1.y == 0;
         if ((basePoint1 ? point2.x : point1.x) == 2 && (basePoint1 ? point2.y : point1.y) == 2) {
            return reversed ? 3 : 1;
         }

         if ((basePoint1 ? point2.x : point1.x) == 2 && (basePoint1 ? point2.y : point1.y) == 1) {
            return 1;
         }

         if ((basePoint1 ? point2.x : point1.x) == 1 && (basePoint1 ? point2.y : point1.y) == 2) {
            return 0;
         }
      }

      return 0;
   }

   public static java.awt.Point[] getPointsFromShapeAndRotation(int shape, int rotation) {
      return shapes.get(shape) == null ? null : shapes.get(shape).getPointsByRotation(rotation);
   }

   public boolean isReversedShape(int shape, int rotation) {
      return false;
   }

   public static Shape getShape(int shape) {
      return shapes.get(shape);
   }

   private Shape(java.awt.Point[][] pointsAtRotation) {
      this.pointsByRotation = pointsAtRotation;
   }

   public int getShapeValue() {
      return this.shapeValue;
   }

   public java.awt.Point[][] getPoints() {
      return this.pointsByRotation;
   }

   public java.awt.Point[] getPointsByRotation(int rotation) {
      return this.pointsByRotation[rotation];
   }
}
