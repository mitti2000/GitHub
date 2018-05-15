using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
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
using Datasource;


namespace WPFTestat
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private int customerIndex = 0;
        private Data data;
        private List<Customer> customerData;
        public Customer CurrentCustomer { get; set; }

        public MainWindow()
        {
            InitializeComponent();
            var routedEventHandler = new RoutedEventHandler(OnMainWindowLoaded);
            Loaded += routedEventHandler;
            CloseButton.Click += OnCloseButtonClick;
            PreviousCust.Click += OnPreviousCustomer;
            NextCust.Click += OnNextCustomer;
            CustomerList.SelectionChanged += OnListSelectionChanged;
        }

        private void OnListSelectionChanged(object sender, RoutedEventArgs e)
        {
            ListBox listBox = sender as ListBox;
            Customer selectedCustomer = listBox.SelectedItem as Customer;
            customerIndex = customerData.IndexOf(selectedCustomer);
            SetCustomer();
            SetBindings();
        }

        private void OnMainWindowLoaded(object sender, RoutedEventArgs e)
        {
            data = Data.Load();
            customerData = data.Customers.CustomerList;
            CustomerList.ItemsSource = customerData;
            CustomerList.SelectionMode = SelectionMode.Single;
            SetCustomer();
            SetBindings();
        }

        private void OnCloseButtonClick(object sender, RoutedEventArgs e)
        {
            SaveCustomer();
            this.Close();
            data.Save();
            Application.Current.Shutdown();

        }

        private void OnNextCustomer(object sender, RoutedEventArgs e)
        {
            SaveCustomer();
            if (customerIndex < (customerData.Count-1))
            {
                customerIndex++;
                SetCustomer();
            }
        }

        private void OnPreviousCustomer(object sender, RoutedEventArgs e)
        {
            SaveCustomer();
            if (customerIndex > 0)
            {
                customerIndex--;
                SetCustomer();
            }
        }

        private void SetCustomer()
        {
            CurrentCustomer = customerData[customerIndex];
            SetBindings();
        }

        private void SaveCustomer()
        {
            customerData[customerIndex] = CurrentCustomer;
            SetBindings();
        }

        public void SetBindings()
        {
            CustomerGrid.DataContext = CurrentCustomer;
        }

    }


}
