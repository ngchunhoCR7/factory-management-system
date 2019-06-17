package factory.management.system.project.controller;

import factory.management.system.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ServerController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/17 15:37
 */
@Controller
@RequestMapping("/server")
public class ServerController {

    @Autowired
    private EmployeeService employeeService;

}
