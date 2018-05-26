using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FolderRandomizer
{
    class Randomizer
    {
        public string FolderPath { get; set; }
        public int MaxPlaylistSize { get; set; }

        public Randomizer(string folderPath, int maxPlaylistSize)
        {
            FolderPath = folderPath;
            MaxPlaylistSize = maxPlaylistSize;

        }

        public void Output()
        {
            if (Directory.Exists(FolderPath))
            {
                List<string> filesInFolder = Directory.GetFiles(FolderPath).ToList();
                Random rnd = new Random();
                int playlistCount = 0;
                while (playlistCount < 10)
                {
                    Console.WriteLine($"Playlist Number{playlistCount+1}");
                    for (int i = 0; i < MaxPlaylistSize; i++)
                    {
                        int index = rnd.Next(filesInFolder.Count);
                        Console.WriteLine($"Index: {index} : {Path.GetFileName(filesInFolder[index])}");
                        
                    }
                    Console.WriteLine("-------------------------------------------------------");
                    playlistCount++;
                }
            }
        }


    }
}
