package com.example.laundryapp.controllers;


import com.example.laundryapp.dto.MachineDto;
import com.example.laundryapp.service.MachineService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/machine")
public class MachineController {

    private MachineService machineService;

    @PostMapping
    public ResponseEntity<MachineDto> createMachine(@RequestBody MachineDto machineDto) {

        MachineDto machine = machineService.createMachine(machineDto);

        return new ResponseEntity<>(machine, HttpStatus.CREATED);


    }

    @GetMapping("{id}")
    public ResponseEntity<MachineDto> getMachineById(@PathVariable("id") Long machineId){
        MachineDto machineDto= machineService.getMachineById(machineId);
        return ResponseEntity.ok(machineDto);
    }

    @GetMapping
    public ResponseEntity<List<MachineDto>> getAllMachine(){
        List<MachineDto> machines = machineService.getAllMachines();
        return ResponseEntity.ok(machines);
    }

    @PutMapping("{id}")
    public ResponseEntity<MachineDto> updateMachine(@PathVariable("id") Long machineId,
                                                      @RequestBody MachineDto updatedMachine){
        MachineDto machineDto = machineService.updateMachines(machineId,updatedMachine );
        return ResponseEntity.ok(machineDto);
    }


}
