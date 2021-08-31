from faker import Faker
from faker.providers import internet
from faker.providers import ssn

fake = Faker()
fake.add_provider(internet)

fake.add_provider(ssn)

print(fake.ssn())

print(fake.ipv4_private())


ssn = fake.ssn()

file=open('C:/KatalonStudio/KatalonProject/ssn-python/ssn1.txt','w')
file.write(ssn)
file.write("\n")
file.close()