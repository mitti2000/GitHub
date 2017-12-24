using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Text;
using System.Threading.Tasks;

namespace LibraryAssistant
{
    public class FileCopier
    {
        private readonly string _path;
        private string _targetPath;
        public FileCopier(string path)
        {
            _path = path;
        }

        public bool copyFile(string target)
        {
            _targetPath = target;
            if (!File.Exists(_path)) return false;

            bool found = false;
            
            string temppath = _path;
            int counter = 0;
            while (!found && counter < 20)
            {
                if (Directory.GetParent(temppath).FullName == "C:\\temp")
                {
                    found = true;
                }
                else
                {
                    temppath = Directory.GetParent(temppath).FullName;
                }
                counter++;
            }

            if (!found) return false;

            File.Move(_path, _targetPath+"\\"+Path.GetFileName(_path));

            return true;
        }
    }
}
