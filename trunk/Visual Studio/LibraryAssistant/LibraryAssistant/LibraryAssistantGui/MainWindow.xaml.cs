using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using LibraryAssistant;

namespace LibraryAssistantGui
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private FileWatcher _fileWatcher;
        public MainWindow()
        {
            _fileWatcher = LibraryAssistantService.FileWatcher1;
            InitializeComponent();
        }

        private void btnAddPath_Click(object sender, RoutedEventArgs e)
        {
            _fileWatcher.ChangePath(txtbx_path.Text);
        }
        
    }
}
