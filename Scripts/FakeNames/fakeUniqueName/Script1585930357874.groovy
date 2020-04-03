import com.github.javafaker.Faker


Random rand = new Random();

List<String> names = new ArrayList<>();

for(int i = 0; i < 100; i++){
	Faker faker = new Faker(new Random(rand.nextInt(100000)));
	String name = faker.name().firstName();
	names.add(name);
	//System.out.println(name);
}
Set<String> namesSet = new HashSet<String>(names);

for(String s: namesSet){
	//System.out.println(s);
}
System.out.println("unique names in a list: "+namesSet.size());