using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;
using Datasource;
using WpfExercise.Annotations;
using WpfExercise.Services;

namespace WpfExercise.View_Model
{
    public class CustomersViewModel
    {
        private CustomersRepository repository;
        private Customer _currentCustomer;

        public CustomersViewModel()
        {
            repository = new CustomersRepository();
            this.Customers =
                new ObservableCollection<Customer>(repository.GetCustomersAsync().Result);
            this.SaveCommand = new RelayCommand(OnSave, CanSave);
        }

        private void OnSave()
        {
            repository.UpdateCustomerAsync(CurrentCustomer);
        }

        private bool CanSave()
        {
            return CurrentCustomer != null;
        }

        public ObservableCollection<Customer> Customers { get; set; }

        public Customer CurrentCustomer
        {
            get { return _currentCustomer; }
            set
            {
                _currentCustomer = value;
                SaveCommand.RaiseCanExecuteChanged();
            }
        }

        public RelayCommand SaveCommand { get; private set; }
    }

}
