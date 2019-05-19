import selenium
import modules.utils as utils
import logging
import time

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

  
  