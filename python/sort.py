from natsort import natsorted, ns


print("used natsort")
print(natsorted(names, key=lambda y: y.lower()))

def sort_list_ascending():
    pass
    
def myFunction(arg1,arg2,arg3):
    print "calling python function with paramters:"
    print arg1
    print arg2
    print arg3
myFunction(sys.argv[0], sys.argv[1], sys.argv[2])