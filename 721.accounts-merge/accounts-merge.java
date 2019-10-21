import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Person {
    String name;
    HashSet<String> emails;

    public Person(String name) {
        this.name = name;
        emails = new HashSet<>();
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null || accounts.size() == 0) {
            return null;
        }
        List<List<String>> result = new ArrayList<>();
        HashMap<String, Person> map = new HashMap<>();
        HashSet<Person> people = new HashSet<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            Person person = new Person(name);
            Person personInMap = null;
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                person.emails.add(email);
                if (map.containsKey(email)) {
                    personInMap = map.get(email);
                    if (personInMap != person) {
                        map.put(email, person);
                        people.remove(personInMap);
                        for (String redundantEmail : personInMap.emails) {
                            map.put(redundantEmail, person);
                        }
                        person.emails.addAll(personInMap.emails);
                    }
                } else {
                    map.put(email, person);
                }
            }
            people.add(person);
        }
        for (Person person : people) {
            List<String> account = new ArrayList<>();
            String name = person.name;
            ArrayList<String> emails = new ArrayList<>(person.emails);
            emails.sort(Comparator.naturalOrder());
            account.add(name);
            account.addAll(emails);
            result.add(account);
        }
        return result;
    }
}