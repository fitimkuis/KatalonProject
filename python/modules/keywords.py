import selenium
import modules.utils as utils
import logging
import time

import pandas as pd
import os
from sys import exit

def hello_world(allArgs, *numbers):
  print("Hello, World from print")
  logging.warning("Hello, World from logging.info")
  print("Sum of", numbers)
  s = sum(numbers)
  print("Sum is", s)
  return s

def goto_google(allArgs):
  driver = utils.get_driver(allArgs)
  driver.get("https://google.com")
  input_element = driver.find_element_by_name("q")
  input_element.send_keys("Search and close after 5 seconds")
  input_element.submit()
  time.sleep(5)
  
def goto_katalon_demo(allArgs):
  driver = utils.get_driver(allArgs)
  driver.get("https://katalon-demo-cura.herokuapp.com/")
  driver.find_element_by_id("btn-make-appointment").click()
  input_element = driver.find_element_by_id("txt-username")
  input_element.send_keys("John Doe")
  input_element = driver.find_element_by_id("txt-password")
  input_element.send_keys("ThisIsNotAPassword")
  driver.find_element_by_id("btn-login").click()
  time.sleep(3)
  input_element = driver.find_element_by_id("combo_facility")
  input_element.send_keys("Hongkong CURA Healthcare Center")
  driver.find_element_by_id("chk_hospotal_readmission").click()
  driver.find_element_by_id("radio_program_medicaid").click()
  
def compare_csv(allArgs, csv1, csv2):
  print("COMPARE CSV")
  print csv1
  print
  print csv2
  deff file3 = System.getProperty("user.dir")+"\\python\\modules\\update.csv";
  print file3
  t = os.path.isfile(file3)
  print t
  if t == True:
      os.remove(file3)
  A=set(pd.read_csv(csv1, index_col=False, header=None)[0]) #reads the csv, takes only the first column and creates a set out of it.
  B=set(pd.read_csv(csv2, index_col=False, header=None)[0]) #same here
  print("missing rows from file2 %s "%(A-B)) #set A - set B gives back everything thats only in A.
  messageA = A-B
  messageB = B-A
  #print messageA
  a = list(messageA)
  b = list(messageB)

  print a
  print b
  #print ("missing rows from file1 %s "%(B-A))
	
  with open(diff, 'w') as outFile:
      if a == b:
          outFile.write(" files are identical\n")
          exit()
	
	 
  with open(diff, 'w') as outFile:
      outFile.write(" added in file1 but missing from file2\n")
      for line in a:
          outFile.write(line)
          outFile.write("\n")
	
  with open(diff, 'a') as outFile:
      outFile.write("\n added in file2 but missing from file1\n")
      for line in b:
          outFile.write(line)
          outFile.write("\n")
  logging.warning("Diffrences written to file diff.csv")
	
 
