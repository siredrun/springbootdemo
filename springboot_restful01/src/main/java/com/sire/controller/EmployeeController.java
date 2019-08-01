package com.sire.controller;

import com.sire.dao.DepartmentDao;
import com.sire.dao.EmployeeDao;
import com.sire.entities.Department;
import com.sire.entities.Employee;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    // 添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    // 员工添加
    // springmvc自动将请求参数和对象属性一一对应，名字一致
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("员工信息：" + employee);
        // 保存员工
        employeeDao.save(employee);
        // 来到员工列表页面
        // redirect重定向 forward转发 /代表当前项目路径
        return "redirect:/emps";
    }

    // 来到修改页面，查出当前员工，在页面会显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
//        ErrorMvcAutoConfiguration
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        // 查询所有部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "/emp/edit";
    }

    // 员工修改 需提交修改的员工ID
    @PutMapping("/emp")
    public String update(Employee employee){
        System.out.println("修改员工："+employee);
        // 保存修改员工 save方法里面有写，如果对象Id为空，自增。不为空就获取对象ID
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    // 员工删除
    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable("id") Integer id){
        System.out.println("删除的员工信息："+employeeDao.get(id));
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
