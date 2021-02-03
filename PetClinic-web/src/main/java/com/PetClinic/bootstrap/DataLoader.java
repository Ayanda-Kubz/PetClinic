package com.PetClinic.bootstrap;

import com.PetClinic.model.*;
import com.PetClinic.services.PetTypeService;
import com.PetClinic.services.SpecialityService;
import com.PetClinic.services.map.OwnerServiceMap;
import com.PetClinic.services.map.SpecialityServiceMap;
import com.PetClinic.services.map.VetServiceMap;
import com.PetClinic.services.OwnerService;
import com.PetClinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private OwnerService ownerService;
    private VetService vetService;
    private PetTypeService petTypeService;
    private SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService= specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Speciality radiology  = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery  = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry  = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Ayanda");
        owner1.setLastName("Kubeka");
        owner1.setAddress("123 Maven street");
        owner1.setCity("Springboot");
        owner1.setTelephone("0321456987");

        Pet ayosPet =new Pet();
        ayosPet.setPetType(saveDogPetType);
        ayosPet.setOwner(owner1);
        ayosPet.setBirthDate(LocalDate.now());
        ayosPet.setName("Bobby");

        owner1.getPets().add(ayosPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glen");
        owner2.setAddress("123 Maven street");
        owner2.setCity("Springboot");
        owner2.setTelephone("0321456987");

        Pet fifisPet =new Pet();
        fifisPet.setPetType(saveCatPetType);
        fifisPet.setOwner(owner2);
        fifisPet.setBirthDate(LocalDate.now());
        fifisPet.setName("Alex");

        owner2.getPets().add(fifisPet);
        ownerService.save(owner2);

        System.out.println("Loaded  owners ....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Axe");
        vet1.setLastName("Roy");
        vet1.getSpecialities().add(savedSurgery);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("James");
        vet2.setLastName("Smaart");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet2);

        System.out.println("Loaded Vets ....");
    }
}
