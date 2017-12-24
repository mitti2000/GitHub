using System;
using System.Collections.Generic;
using System.Dynamic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LibraryAssistant
{
    

    public class FileWatcher
    {
        private FileSystemWatcher _fileObeserver;


        public FileWatcher()
        {
            _fileObeserver = new FileSystemWatcher();
        }

        public FileWatcher(string path)
        {
            _fileObeserver = new FileSystemWatcher(path);
        }

        public FileSystemWatcher FileObserver { get { return _fileObeserver; } set { _fileObeserver = value; } }

        public void ChangePath(string path)
        {
            _fileObeserver.Path = path;
            OnPathChanged(path);
        }

        public event Action<string> OnPathChanged;
    }
}
