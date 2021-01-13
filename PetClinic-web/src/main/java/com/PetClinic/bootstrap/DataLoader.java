package com.PetClinic.bootstrap;

import com.PetClinic.model.PetType;
import com.PetClinic.services.PetTypeService;
import com.PetClinic.services.map.OwnerServiceMap;
import com.PetClinic.services.map.VetServiceMap;
import com.PetClinic.model.Owner;
import com.PetClinic.model.Vet;
import com.PetClinic.services.OwnerService;
import com.PetClinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private OwnerService ownerService;
    private VetService vetService;
    private PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;

    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Ayanda");
        owner1.setLastName("Kubeka");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glen");
        ownerService.save(owner2);

        System.out.println("Loaded  owners ....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Axe");
        vet1.setLastName("Roy");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("James");
        vet2.setLastName("Smaart");
        vetService.save(vet2);

        System.out.println("Loaded Vets ....");
    }
}
