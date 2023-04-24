/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Controller;

/**
 *
 * @author valdiviaricardo
 */
@RestController
@RequestMapping("/educacion")
public class EducacionController {

    @Autowired
    private EducacionService educacionService;

    @GetMapping
    public List<EducacionDto> getAll() {
        return educacionService.findAll();
    }

    @PostMapping
    public EducacionDto create(@RequestBody EducacionDto educacionDto) {
        return educacionService.save(educacionDto);
    }

    @GetMapping("/{id}")
    public EducacionDto getById(@PathVariable Long id) {
        return educacionService.findById(id);
    }

    @PutMapping("/{id}")
    public EducacionDto update(@PathVariable Long id, @RequestBody EducacionDto educacionDto) {
        return educacionService.update(id, educacionDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        educacionService.deleteById(id);
    }
}