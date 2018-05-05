using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VektorTestat
{

    class Vektor3D
    {

        private int _a1;
        private int _a2;
        private int _a3;

        public Vektor3D(int a1, int a2, int a3)
        {
            _a1 = a1;
            _a2 = a2;
            _a3 = a3;
        }

        public static Vektor3D operator +(Vektor3D a, Vektor3D b)
        {
            return new Vektor3D(a[1] + b[1], a[2] + b[2], a[3] + b[3]);
        }

        public static Vektor3D operator -(Vektor3D a, Vektor3D b)
        {
            return new Vektor3D(a[1] - b[1], a[2] - b[2], a[3] - b[3]);
        }

        public static Vektor3D operator *(Vektor3D a, Vektor3D b)
        {
            int a1 = (a[2] * b[3]) - (a[3] * b[2]);
            int a2 = (a[3] * b[1]) - (a[1] * b[3]);
            int a3 = (a[1] * b[2]) - (a[2] * b[1]);
            return new Vektor3D(a1,a2,a3);
        }

        public static bool operator ==(Vektor3D a, Vektor3D b)
        {
            if (a[1] == b[1] && a[2] == b[2] && a[3] == b[3]) return true;
            return false;
        }

        public static bool operator !=(Vektor3D a, Vektor3D b)
        {
            if (a[1] != b[1] || a[2] != b[2] || a[3] != b[3]) return true;
            return false;
        }

        public int this[int index]
        {
            get
            {
                switch (index)
                {
                    case 1:
                        return _a1;
                    case 2:
                        return _a2;
                    case 3:
                        return _a3;
                    default:
                        return 0;
                }
            }

            set
            {
                switch (index)
                {
                    case 1:
                        _a1 = value;
                        break;
                    case 2:
                        _a2 = value;
                        break;
                    case 3:
                        _a3 = value;
                        break;                     
                }
            }
        }

        public override string ToString()
        {
            return $"Vektor ist: A1={_a1}, A2={_a2}, A3={_a3}";
        }

        public double VektorBetrag()
        {
            return Math.Sqrt((_a1 * _a1) + (_a2 * _a2) + (_a3 * _a3));
        }
    }
}
