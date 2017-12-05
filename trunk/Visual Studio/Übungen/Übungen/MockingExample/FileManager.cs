using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MockingExample
{
    class FileManager
    {
        private IFileWrapper _fileWrapper;

        public FileManager(IFileWrapper fileWrapper)
        {
            _fileWrapper = fileWrapper;
        }

        public void deleteAll()
        {
            _fileWrapper.deleteAll();elete(file);
        }

    }


}