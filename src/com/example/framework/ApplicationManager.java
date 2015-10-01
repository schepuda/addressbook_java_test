package com.example.framework;

import java.util.Properties;

import org.netbeans.jemmy.ClassReference;
import org.netbeans.jemmy.operators.JFrameOperator;


public class ApplicationManager {
	
		private static ApplicationManager singleton;
		
		private Properties props;

		private FolderHelper folderHelper;

		private JFrameOperator mainFrame;

		private MenuHelper menuHelper;
		
		public static ApplicationManager getInstance() {
			if (singleton == null) {
				singleton= new ApplicationManager();
			}
			return singleton;
		}
		
		public void stop() {
		}

				
		public void setProperties (Properties props) {
			this.props = props;
		}
		
		public String getProperty (String key) {
			return props.getProperty(key);
		}
		
		public String getProperty (String key, String defaultValue) {
			return props.getProperty(key, defaultValue);
		}

		public FolderHelper getFolderHelper() {
			if (folderHelper == null) {
				folderHelper = new FolderHelper(this);
			}
			return folderHelper;
		}

		public JFrameOperator getApplication() {
			if (mainFrame == null) {
			try {
				new ClassReference("addressbook.AddressBookFrame").startApplication();
				mainFrame = new JFrameOperator("jAddressBook");
			} catch (Exception e) {
				e.printStackTrace();
			   }
			}
			return mainFrame;
			
		}

		public MenuHelper getMenuHelper() {
			if (menuHelper == null) {
				menuHelper = new MenuHelper(this);
			}
			return menuHelper;
		}
		
}