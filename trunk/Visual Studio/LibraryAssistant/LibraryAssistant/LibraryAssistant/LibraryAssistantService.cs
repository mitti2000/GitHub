using System;
using System.Diagnostics;
using System.Dynamic;
using System.IO;
using System.Runtime.InteropServices;
using System.ServiceProcess;
using System.Timers;

namespace LibraryAssistant
{
    public partial class LibraryAssistantService : ServiceBase
    {

        //private int libraryAssistentEventId = 1;
        private static FileWatcher _fileWatcher;

        

        public LibraryAssistantService()
        {
            
                InitializeComponent();


                libraryAssistantEventLog = new EventLog();
                if (!EventLog.SourceExists("LibraryAssistantEventSource"))
                {
                    EventLog.CreateEventSource("LibraryAssistantEventSource", "LibraryAssistantLog");
                }
                libraryAssistantEventLog.Source = "LibraryAssistantEventSource";
                libraryAssistantEventLog.Log = "LibraryAssistantLog";
            
            
        }

        
        private void FileObserver_Created(object sender, FileSystemEventArgs e)
        {
            libraryAssistantEventLog.WriteEntry(e.FullPath);
        }

        protected override void OnStart(string[] args)
        {
            // Update the service state to Start Pending.  
            ServiceStatus serviceStatus = new ServiceStatus();
            serviceStatus.dwCurrentState = ServiceState.SERVICE_START_PENDING;
            serviceStatus.dwWaitHint = 100000;
            SetServiceStatus(ServiceHandle, ref serviceStatus);

            CreateFileWatcher();

            libraryAssistantEventLog.WriteEntry("FileWatcher started on Path: " + _fileWatcher.FileObserver.Path);

            libraryAssistantEventLog.WriteEntry("LibraryAssistant started");



            // Update the service state to Running.  
            serviceStatus.dwCurrentState = ServiceState.SERVICE_RUNNING;
            SetServiceStatus(ServiceHandle, ref serviceStatus);
        }

        private void CreateFileWatcher()
        {
            _fileWatcher = new FileWatcher();
            _fileWatcher.FileObserver.Created += FileObserver_Created;
        }

        public static FileWatcher FileWatcher1
        {
            get { return _fileWatcher; }
        }

        private void PathChanged()
        {
            libraryAssistantEventLog.WriteEntry("FileWatcher Path changed to: " + _fileWatcher.FileObserver.Path);
        }

        protected override void OnStop()
        {
            // Update the service state to Stop Pending.  
            ServiceStatus serviceStatus = new ServiceStatus();
            serviceStatus.dwCurrentState = ServiceState.SERVICE_STOP_PENDING;
            serviceStatus.dwWaitHint = 100000;
            SetServiceStatus(ServiceHandle, ref serviceStatus);

            libraryAssistantEventLog.WriteEntry("LibraryAssistant stopped");

            // Update the service state to Stopped.  
            serviceStatus.dwCurrentState = ServiceState.SERVICE_STOPPED;
            SetServiceStatus(ServiceHandle, ref serviceStatus);
        }

        protected override void OnCustomCommand(int command)
        {
            base.OnCustomCommand(command);
            if (command == 1)
            {
                PathChanged();
            }
        }


        [DllImport("advapi32.dll", SetLastError = true)]
        private static extern bool SetServiceStatus(IntPtr handle, ref ServiceStatus serviceStatus);

        private void libraryAssistantEventLog_EntryWritten(object sender, EntryWrittenEventArgs e)
        {

        }

        public void TestMethod()
        {
            libraryAssistantEventLog.WriteEntry("Method called");
        }


    }

    public enum ServiceState
    {
        SERVICE_STOPPED = 0x00000001,
        SERVICE_START_PENDING = 0x00000002,
        SERVICE_STOP_PENDING = 0x00000003,
        SERVICE_RUNNING = 0x00000004,
        SERVICE_CONTINUE_PENDING = 0x00000005,
        SERVICE_PAUSE_PENDING = 0x00000006,
        SERVICE_PAUSED = 0x00000007
    }

    [StructLayout(LayoutKind.Sequential)]
    public struct ServiceStatus
    {
        public int dwServiceType;
        public ServiceState dwCurrentState;
        public int dwControlsAccepted;
        public int dwWin32ExitCode;
        public int dwServiceSpecificExitCode;
        public int dwCheckPoint;
        public int dwWaitHint;
    }

}
