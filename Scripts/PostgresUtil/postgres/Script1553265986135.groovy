import java.text.DecimalFormat

com.github.javafaker.Faker faker = new com.github.javafaker.Faker();
List <String> data = new ArrayList<>()
Random r = new Random();
double random = new Random().nextDouble();
int lowerAge = 30;
int upperAge = 65;

double lowerSalary = 30000;
double upperSalary = 65000;

//double salary = r.nextDouble(upperSalary-lowerSalary) + lowerSalary;

double salary = r.nextDouble()*(upperSalary - lowerSalary) + lowerSalary;
DecimalFormat f = new DecimalFormat("##.00");

String s = String.valueOf(f.format(salary));
println s

//String streetAddress = faker.address().streetAddress();
//String streetName = faker.address().streetName();
//String number = faker.address().buildingNumber();
//String country = faker.address().country();

for (int i = 0; i < 10; i++){
	String firsName = faker.name().firstName()
	data.add(firsName)
	int age = r.nextInt(upperAge-lowerAge) + lowerAge;
	data.add(String.valueOf(age))
	String city = faker.address().city();
	data.add(city)
	salary = r.nextDouble()*(upperSalary - lowerSalary) + lowerSalary;
	f = new DecimalFormat("##.00");
	//f.format(salary)
	data.add(String.valueOf(f.format(salary).replace(",",".")))
}
println data
println data.get(0)
String sally = data.get(3)
sally = sally.replace(",", ".");
//double salary2 = Double.valueOf(data.get(3))
println sally
int count = CustomKeywords.'postgresUtil.postgresHandler.getRowCount'()
CustomKeywords.'postgresUtil.postgresHandler.insertIntoFromList'(data, count + 1)
CustomKeywords.'postgresUtil.postgresHandler.selectData'()