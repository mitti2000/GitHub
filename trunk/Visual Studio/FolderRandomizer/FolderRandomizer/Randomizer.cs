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
        public string SourceFolderPath { get; set; }
        public string TargetFolderPath { get; set; }
        public int MaxPlaylistSize { get; set; }

        public Randomizer(string sourceFolderPath, string targetFolderPath, int maxPlaylistSize)
        {
            TargetFolderPath = targetFolderPath;
            SourceFolderPath = sourceFolderPath;
            MaxPlaylistSize = maxPlaylistSize;

        }


        public void Output()
        {
            if (Directory.Exists(SourceFolderPath))
            {
                List<string> filesInFolder = Directory.GetFiles(SourceFolderPath).ToList();
                int playlistAmount = 0;
                if (filesInFolder.Count % MaxPlaylistSize == 0)
                {
                    playlistAmount = filesInFolder.Count / MaxPlaylistSize;
                }
                else
                {
                    playlistAmount = (filesInFolder.Count / MaxPlaylistSize) + 1;
                }
                Random rnd = new Random();
                int playlistCount = 0;
                int max = filesInFolder.Count;
                int currentFileCopied = 0;
                while (playlistCount < playlistAmount)
                {
                    Console.WriteLine($"Playlist Number{playlistCount+1}");
                    string playlistFolder = "Random " + (playlistCount+1);
                    Directory.CreateDirectory(Path.Combine(TargetFolderPath, playlistFolder));
                    for (int i = 0; i < MaxPlaylistSize; i++)
                    {
                        if (filesInFolder.Count < 1)
                        {
                            return;
                        }
                        int index = rnd.Next(filesInFolder.Count);
                        currentFileCopied++;
                        string fileName = Path.GetFileName(filesInFolder[index]);
                        File.Copy(Path.Combine(SourceFolderPath,fileName), Path.Combine(TargetFolderPath, playlistFolder, fileName));
                        Console.WriteLine($"Index: {index} : {Path.GetFileName(filesInFolder[index])} // {currentFileCopied} of {max}");
                        filesInFolder.RemoveAt(index);
                    }
                    Console.WriteLine("-------------------------------------------------------");
                    playlistCount++;
                }
            }
        }


    }
}
