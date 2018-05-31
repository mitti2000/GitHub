using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Input;
using System.Drawing;

namespace ClickMyDrugs
{
    class Program
    {
        private const int MOUSEEVENTF_MOVE = 0x0001; /* mouse move */
        private const int MOUSEEVENTF_LEFTDOWN = 0x0002; /* left button down */
        private const int MOUSEEVENTF_LEFTUP = 0x0004; /* left button up */
        private const int MOUSEEVENTF_RIGHTDOWN = 0x0008; /* right button down */
        private const int VK_ESCAPE = 0x1B; /* Escape Down */

        static void Main(string[] args)
        {
            Thread.Sleep(5000);
            bool inside = false;
            int sleepTime = 5;

            while (true)
            {
                while (!inside)
                {
                    if (GetCursorPosition().X > 150
                        && GetCursorPosition().X < 190
                        && GetCursorPosition().Y > 240
                        && GetCursorPosition().Y < 430)
                    {
                        inside = true;
                    }
                }

                while (inside)
                {

                    SetCursorPos(173, 254);
                    for (int i = 0; i < 500; i++)
                    {
                        Thread.Sleep(sleepTime);
                        mouse_event(MOUSEEVENTF_LEFTDOWN, 0, 0, 0, 0);
                        mouse_event(MOUSEEVENTF_LEFTUP, 0, 0, 0, 0);
                        if (!(GetCursorPosition().X > 150
                              && GetCursorPosition().X < 190
                              && GetCursorPosition().Y > 240
                              && GetCursorPosition().Y < 430))
                        {
                            inside = false;
                            break;
                        }
                    }

                    SetCursorPos(173, 418);
                    for (int i = 0; i < 1000; i++)
                    {
                        Thread.Sleep(sleepTime);
                        mouse_event(MOUSEEVENTF_LEFTDOWN, 0, 0, 0, 0);
                        mouse_event(MOUSEEVENTF_LEFTUP, 0, 0, 0, 0);
                        if (!(GetCursorPosition().X > 150
                              && GetCursorPosition().X < 190
                              && GetCursorPosition().Y > 240
                              && GetCursorPosition().Y < 430))
                        {
                            inside = false;
                            break;
                        }
                    }
                }
            }
        }

        [DllImport("user32")]
        public static extern int SetCursorPos(int x, int y);

        [DllImport("user32.dll")]
        public static extern int GetCursorPos(out POINT lpPoint);

        [DllImport("user32.dll", CharSet = CharSet.Auto, CallingConvention = CallingConvention.StdCall)]
        public static extern void mouse_event(int dwFlags, int dx, int dy, int cButtons, int dwExtraInfo);

        public static Point GetCursorPosition()
        {
            POINT lpPoint;
            GetCursorPos(out lpPoint);
            //bool success = User32.GetCursorPos(out lpPoint);
            // if (!success)

            return lpPoint;
        }

        public struct POINT
        {
            public int X;
            public int Y;

            public static implicit operator Point(POINT point)
            {
                return new Point(point.X, point.Y);
            }
        }
    }
}
