package com.PetClinic.bootstrap;

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

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Ayanda");
        owner1.setLastName("Kubeka");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glen");
        ownerService.save(owner2);

        System.out.println("Loaded  owners ....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Axe");
        vet1.setLastName("Roy");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("James");
        vet2.setLastName("Smaart");
        vetService.save(vet2);

        System.out.println("Loaded Vets ....");
    }
}
