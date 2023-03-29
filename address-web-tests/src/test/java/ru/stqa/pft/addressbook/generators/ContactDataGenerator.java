package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
  @Parameter(names = "-c", description = "Group count")
  public int count;
  @Parameter(names = "-f", description = "Target file")
  public String file;
  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex){
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactDate> contacts = generateContact(count);
    save(contacts, new File(file));
  }

  private static void save(List<ContactDate> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactDate contact : contacts) {
      writer.write(String.format("%s;%s;%s;%s;%s;%s;%s\n",contact.getFirstname(), contact.getMiddlename(), contact.getLastname(), contact.getMobile(), contact.getEmail(), contact.getAddress(), contact.getGroup()));
    }
    writer.close();
  }
  private static List<ContactDate> generateContact(int count) {
    List<ContactDate> contacts = new ArrayList<ContactDate>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactDate().withFirstname(String.format("Test %s", i)).withMiddlename(String.format("Testovich %s",i)).withLastname(String.format("Testovii %s", i))
              .withMobile(String.format("89277465676 %s", i)).withEmail(String.format("test@test.com %s", i)).withAddress(String.format("Moscow %s", i)).withGroup(String.format("test 1",i)));
    }
    return contacts;
  }
}
