   M S B A M L   `   `   `  ����H  DMVVMCommsDemo, Version=1.0.0.0, Culture=neutral, PublicKeyToken=nullA%clr-namespace:MVVMCommsDemo.CustomersMVVMCommsDemo.Customers  5      -clr-namespace:MVVMCommsDemoMVVMCommsDemo  5      .    (MVVMCommsDemo.Customers.CustomerListView   5      \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      6cust%clr-namespace:MVVMCommsDemo.Customers     5      -localclr-namespace:MVVMCommsDemo     5      Hi:http://schemas.microsoft.com/expression/2010/interactivity     5      Hei9http://schemas.microsoft.com/expression/2010/interactions     5      !   MVVMCommsDemo.MvvmBehaviors    LoadedMethodName$  LoadCustomers��5       � 	Resources 5         CustomerTemplate��%�   &	        �� 5   
   .R�5      �� $��3q�6   
����  �._�5      �� .+�5      �� ��6    �� *	FirstName+�� 5      ��6    �� *
LastName+�� 5      ��6    �� *Phone+5      5      5      5       J� InputBindings 5      �� 5   
   
 �� Key$ D��6    �� 	Modifiers$ Controlf�5       �� Command 5      �� *DeleteCommand+ � DataContext 5      3   -MVVMCommsDemo.Customers.CustomerListViewModel  5    
   .��5(      �  � RowDefinitions 5)   
   �� 5*      $
��Auto �6   �� 5+      $��2* �6   �� 5,      $��1* �6   .+�5.   
   �� $��Delete��6   $
��Left=�50      $	��Top=�51      $��75��52      ��5/      �� *DeleteCommand+52      &   System.Windows.Controls.DataGrid  56   
   -   5          Name$ customerDataGrid��56      	   AutoGenerateColumns	 .  $��1��5:      ��58      �� *	Customers+
 �� SelectedItem
 59      �� *SelectedCustomer+   Columns 5;      0  *System.Windows.Controls.DataGridTextColumn  5<      ,  &System.Windows.Controls.DataGridColumn   Header$ 
First Name��5=   %      Width5  /System.Windows.Controls.DataGridLengthConverter$ SizeToHeader 5>   %   1  +System.Windows.Controls.DataGridBoundColumn   Binding 5<   %   �� *	FirstName+5>   %     5?      $ 	Last Name��5@   %   $ SizeToHeader 5A   %    5?   %   �� *
LastName+5A   %     5B      $ Phone��5C   %   $ SizeToHeader 5D   %    5B   %   �� *Phone+5D   %   5F      �� 5G   
   #��[  5H      $��2��5I      ��5G      �� *	Customers+5I      5J      5K      