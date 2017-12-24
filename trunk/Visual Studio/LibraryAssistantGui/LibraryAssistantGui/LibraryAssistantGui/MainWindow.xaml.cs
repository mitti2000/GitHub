using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.ServiceProcess;
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
using System.Management;
using System.Threading;


namespace LibraryAssistantGui
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private readonly string _serviceName;
        ServiceController[] scServices;
        private ServiceController _libraryAssistantService;

        public MainWindow()
        {
            
            scServices = ServiceController.GetServices();

            foreach (ServiceController scTemp in scServices)
            {

                if (scTemp.ServiceName == "LibraryAssistantService")
                {
                    // Display properties for the Simple Service sample
                    // from the ServiceBase example.
                    _libraryAssistantService = new ServiceController("LibraryAssistantService");
                    if (_libraryAssistantService.Status == ServiceControllerStatus.Stopped)
                    {
                        MessageBox.Show("Service Not Started", "Error");
                    }
                }
            }
            InitializeComponent();
            
        }
        
        private void btnAddPath_Click(object sender, RoutedEventArgs e)
        {
            _libraryAssistantService.ExecuteCommand((int) SimpleServiceCustomCommands.FileChanged);
        }


    }
    public enum SimpleServiceCustomCommands
    { FileChanged = 1};
}


