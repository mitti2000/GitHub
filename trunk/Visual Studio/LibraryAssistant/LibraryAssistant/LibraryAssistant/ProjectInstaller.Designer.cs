namespace LibraryAssistant
{
    partial class ProjectInstaller
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary> 
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Component Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.libraryAssistantServiceProcessInstaller1 = new System.ServiceProcess.ServiceProcessInstaller();
            this.libraryAssistantServiceInstaller = new System.ServiceProcess.ServiceInstaller();
            // 
            // libraryAssistantServiceProcessInstaller1
            // 
            this.libraryAssistantServiceProcessInstaller1.Account = System.ServiceProcess.ServiceAccount.LocalSystem;
            this.libraryAssistantServiceProcessInstaller1.Password = null;
            this.libraryAssistantServiceProcessInstaller1.Username = null;
            // 
            // libraryAssistantServiceInstaller
            // 
            this.libraryAssistantServiceInstaller.Description = "Service that monitors a source folder and moves files to a target folder when the" +
    "y are created";
            this.libraryAssistantServiceInstaller.DisplayName = "LibraryAssistantService";
            this.libraryAssistantServiceInstaller.ServiceName = "LibraryAssistantService";
            this.libraryAssistantServiceInstaller.StartType = System.ServiceProcess.ServiceStartMode.Automatic;
            // 
            // ProjectInstaller
            // 
            this.Installers.AddRange(new System.Configuration.Install.Installer[] {
            this.libraryAssistantServiceProcessInstaller1,
            this.libraryAssistantServiceInstaller});

        }

        #endregion

        private System.ServiceProcess.ServiceProcessInstaller libraryAssistantServiceProcessInstaller1;
        private System.ServiceProcess.ServiceInstaller libraryAssistantServiceInstaller;
    }
}