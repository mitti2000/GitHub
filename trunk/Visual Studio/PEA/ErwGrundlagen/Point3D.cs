using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ErwGrundlagen
{
    class Point3D
    {
        private int _x;
        private int _y;
        private int _z;

        public Point3D(int x, int y, int z)
        {
            this._x = x;
            this._y = y;
            this._z = z;
        }

        public static Point3D operator + (Point3D a, Point3D b)
        {
            return new Point3D(a[1]+b[1], a[2]+b[2], a[3]+b[3]);
        }


        public int this[int index]
        {
            get
            {
                switch (index)
                {
                    case 1:
                        return _x;
                    case 2:
                        return _y;
                    case 3:
                        return _z;
                    default:
                        return 0;
                }
            }
        }
    }
}
