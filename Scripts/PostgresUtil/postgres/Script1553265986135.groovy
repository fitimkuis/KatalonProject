import java.text.DecimalFormat

import org.joda.time.LocalDate
import org.joda.time.Period

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
//generate ssn 
String ssn = randomAlphaNumeric(3)
println ssn
System.out.println("randomDate: " + randomBirthday());
System.out.println(randomBirthday().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
ssn2 = randomBirthday().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))+"-"+ssn
println ssn2

List <String> ssnString = new ArrayList<>()
for (int w = 0; w <= 54; w++){
	
	ssn = randomAlphaNumeric(3)
	ssn2 = randomBirthday().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))+"-"+ssn
	ssnString.add(ssn2)
}
println ssnString
*/

//style two to generate bird date
/*Random rand = new Random();
int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
long randomDay = minDay + rand.nextInt(maxDay - minDay);
LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
System.out.println(randomBirthDate);*/

com.github.javafaker.Faker faker = new com.github.javafaker.Faker();
List <String> data = new ArrayList<>()
Random r = new Random();
double random = new Random().nextDouble();
int lowerAge = 30;
int upperAge = 65;

double lowerSalary = 30000;
double upperSalary = 65000;

double salary = r.nextDouble()*(upperSalary - lowerSalary) + lowerSalary;
DecimalFormat f = new DecimalFormat("##.00");

String s = String.valueOf(f.format(salary));
println s

String ss = faker.name().lastName()

/*
//generate example data
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
*/
//update salary for id 1
//CustomKeywords.'postgresUtil.postgresHandler.updateSalary'(1, 200000.00)

//update all data for id 1
//CustomKeywords.'postgresUtil.postgresHandler.updateExactData'(1, "Sally", 45, "New York", 100000.00, ssnString)

/*
//get row count
int count = CustomKeywords.'postgresUtil.postgresHandler.getRowCount'()
//insert new rows to the database (10)
CustomKeywords.'postgresUtil.postgresHandler.insertIntoFromList'(data, count + 1)
*/
//select databases data
//CustomKeywords.'postgresUtil.postgresHandler.selectData'()

Object oValue = 47
CustomKeywords.'postgresUtil.postgresHandler.updateColumn'(2, 1, oValue)//2 update column age, 1 row id 1

//updat just added new column where all data are NULL
//CustomKeywords.'postgresUtil.postgresHandler.updateSsn'(ssnString)

public LocalDate randomBirthday() {
	return LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70))));
}

public String randomAlphaNumeric(int count) {
	
	String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	StringBuilder builder = new StringBuilder();
	while (count-- != 0) {
	int character = (int)(Math.random()*alphaNumericString.length());
	builder.append(alphaNumericString.charAt(character));
	}
	return builder.toString();
}

public String getRandomAlphNumeircString(int n) {
	// Get a n-digit multiplier of 10
	int maxDigit = (int) Math.pow(10, n - 2);
	Random random = new Random();
	/*
	 * Get a random character by getting a number from 0 t0 26 and then adding an
	 * 'A' to make it a character
	 *
	 */
	char randomCharacter = (char) (random.nextInt(26) + 'A');
	/*
	 * Add 1*maxDigit to ensure that the number is equals to or greater than minimum
	 * value nextInt() method will return the number between 0 and 9*maxDigit
	 */
	int randomNumber = 1 * maxDigit + random.nextInt(9 * maxDigit);
	return String.valueOf(randomCharacter) + randomNumber;
}