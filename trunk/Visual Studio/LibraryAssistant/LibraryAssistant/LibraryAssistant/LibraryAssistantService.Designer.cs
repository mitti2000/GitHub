namespace LibraryAssistant
{
    partial class LibraryAssistantService
    {
        /// <summary> 
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;
        private System.Diagnostics.EventLog libraryAssistantEventLog;

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
            this.libraryAssistantEventLog = new System.Diagnostics.EventLog();
            ((System.ComponentModel.ISupportInitialize)(this.libraryAssistantEventLog)).BeginInit();
            // 
            // libraryAssistantEventLog
            // 
            this.libraryAssistantEventLog.EntryWritten += new System.Diagnostics.EntryWrittenEventHandler(this.libraryAssistantEventLog_EntryWritten);
            // 
            // LibraryAssistantService
            // 
            this.ServiceName = "LibraryAssistantService";
            ((System.ComponentModel.ISupportInitialize)(this.libraryAssistantEventLog)).EndInit();

        }

        #endregion

        
    }
}
