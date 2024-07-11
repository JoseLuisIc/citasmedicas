package com.consultorio.citasmedicas.controller;

import com.consultorio.citasmedicas.model.Appointment;
import com.consultorio.citasmedicas.model.Doctor;
import com.consultorio.citasmedicas.model.Surgery;
import com.consultorio.citasmedicas.services.AppointmentService;
import com.consultorio.citasmedicas.services.DoctorService;
import com.consultorio.citasmedicas.services.SurgeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class CitaController {

    @Autowired
    private SurgeryService surgeryService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/")
    public String home(Model model) {
        List<Surgery> surgeryList = surgeryService.getAllSurgerys();
        List<Doctor> doctorList = doctorService.getAllDoctors();
        List<Appointment> appointmentList = appointmentService.getAllAppointments();
        model.addAttribute("surgerys",surgeryList);
        model.addAttribute("doctors",doctorList);
        model.addAttribute("citas",appointmentList);
        model.addAttribute("appointments",appointmentList);
        return "index"; // Devuelve el nombre de la plantilla Thymeleaf
    }

    @GetMapping("/appointment/new")
    public String newUserForm(Model model) {
        List<Surgery> surgeryList = surgeryService.getAllSurgerys();
        List<Doctor> doctorList = doctorService.getAllDoctors();
        List<Appointment> appointmentList = appointmentService.getAllAppointments();
        model.addAttribute("surgeries",surgeryList);
        model.addAttribute("doctors",doctorList);
        model.addAttribute("citas",appointmentList);
        model.addAttribute("appointments",appointmentList);
        Appointment appointment = new Appointment();
        model.addAttribute("appointment",appointment);
        return "cita-form"; // nombre de la plantilla Thymeleaf
    }

    // Procesar formulario de creación de cita médica
    @PostMapping("/save")
    public String saveAppointment(@ModelAttribute("appointment") Appointment appointment,RedirectAttributes redirectAttributes,Model model) {
        appointmentService.saveAppointment(appointment);
        redirectAttributes.addFlashAttribute("successMessage", "¡La cita médica se ha Guardado correctamente!");
        model.addAttribute("successMessage", "¡La cita médica se ha Guardado correctamente!");
        return "redirect:/appointment/new";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Appointment> appointment = appointmentService.findById(id);
        model.addAttribute("appointment", appointment);
        List<Surgery> surgeryList = surgeryService.getAllSurgerys();
        List<Doctor> doctorList = doctorService.getAllDoctors();
        model.addAttribute("surgeries",surgeryList);
        model.addAttribute("doctors",doctorList);
        return "cita-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/";
    }

    @GetMapping("/listSurgerys")
    public String listSurgerys(Model model) {
        List<Surgery> surgeryList = surgeryService.getAllSurgerys();
        model.addAttribute("surgeries",surgeryList);
        return "listSurgerys"; // Devuelve el nombre de la plantilla Thymeleaf
    }

    @GetMapping("/listDoctors")
    public String listDoctors(Model model) {
        List<Doctor> doctorList = doctorService.getAllDoctors();
        model.addAttribute("doctors",doctorList);
        return "listDoctors"; // Devuelve el nombre de la plantilla Thymeleaf
    }
}