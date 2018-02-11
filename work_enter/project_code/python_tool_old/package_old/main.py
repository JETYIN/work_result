# -*-coding=utf-8-*-
from PyQt4.QtGui import *  
from PyQt4.QtCore import *  
import sys  
import utils.package
        
class TestDialog(QDialog, utils.package.Ui_Dialog):  
    def __init__(self, parent=None):  
        super(TestDialog, self).__init__(parent)  
        self.setupUi(self)    
app = QApplication(sys.argv)  
dialog = TestDialog() 
dialog.setFixedSize(QSize(902, 831)) 
dialog.setWindowFlags(Qt.WindowMinimizeButtonHint)
dialog.show()  
app.exec_()
