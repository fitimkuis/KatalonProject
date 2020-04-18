import selenium
import modules.utils as utils
import logging
import time
from natsort import natsorted

def hello_world(allArgs, *numbers):
  print("Hello, World from print")
  logging.warning("Hello, World from logging.info")
  print("Sum of", numbers)
  s = sum(numbers)
  print("Sum is", s)
  return s
  
def sort_string(AllArgs, names):
  print("are we here!!!!!!!")
  res = names.strip('][').split(', ')
  res = natsorted(res, key=lambda y: y.lower())
  print(res)
  return res

def goto_google(allArgs):
  driver = utils.get_driver(allArgs)
  driver.get("https://google.com")
  input_element = driver.find_element_by_name("q")
  input_element.send_keys("Search and close after 5 seconds")
  input_element.submit()
  time.sleep(5)