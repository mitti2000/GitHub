using System;
using System.Diagnostics;
using System.Linq.Expressions;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Navigation;
using NetTcpStyleUriParser = System.NetTcpStyleUriParser;

namespace TestUIThread {
    public partial class MainWindow : Window {
        public MainWindow() {
            InitializeComponent();
        }

        private async void startCalculationButton_Click(object sender, RoutedEventArgs e) {
            long initial;
            long amount;
            if (!long.TryParse(baseNumberTextBox.Text, out initial) ||
                !long.TryParse(succeedingPrimesTextBox.Text, out amount)) {
                return;
            }

            startCalculationButton.Content = "Cancel";
            startCalculationButton.Click -= startCalculationButton_Click;
            startCalculationButton.Click += stopCalculation;
            progressLabel.Content = "computing...";
            await ComputeNextPrimes(initial, amount);
            progressLabel.Content = "done";
            startCalculationButton.Content = "Start";
            startCalculationButton.Click -= stopCalculation;
            startCalculationButton.Click += startCalculationButton_Click;
            
        }

        private async Task ComputeNextPrimes(long inital, long amount) {
            for (var number = inital; number < inital + amount; number++) {
                if (await IsPrime(number)) {
                    resultListView.Items.Add(number);
                }
                progressBar.Value = (number-inital)/(amount / 100);
            }
        }

        private Task<bool> IsPrime(long number)
        {
            return Task.Run(() =>
            {
                for (long i = 2; i * i <= number; i++)
                {
                    if (number % i == 0)
                    {
                        return false;
                    }
                }

                return true;
            });
        }

        private void stopCalculation(object sender, RoutedEventArgs e)
        {
            return;
        }
    }
}
