package com.sprhib.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sprhib.model.Team;
import com.sprhib.service.TeamService;

@Controller
@RequestMapping(value = "/team")
public class TeamController {

	@Autowired
	private TeamService teamService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addTeamPage() {
		ModelAndView modelAndView = new ModelAndView("add-team-form");
		modelAndView.addObject("team", new Team());
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addingTeam(@ModelAttribute Team team,
			RedirectAttributes redirectAttrs) {
		teamService.addTeam(team);
		String message = "Team successfully added!";
		redirectAttrs.addFlashAttribute("message", message);
		return "redirect:/team/list";
	}

	@RequestMapping(value = "/list")
	public ModelAndView listOfTeams(@ModelAttribute("message") String message) {
		ModelAndView modelAndView = new ModelAndView("list-of-teams");
		List<Team> teams = new ArrayList<Team>();
		teams = teamService.getTeams();
		modelAndView.addObject("teams", teams);
		modelAndView.addObject("message", message);
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editTeamPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-team-form");
		Team team = teamService.getTeam(id);
		modelAndView.addObject("team", team);
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String edditingTeam(@ModelAttribute Team team,
			@PathVariable Integer id, RedirectAttributes redirectAttrs) {
		teamService.updateTeam(team);
		String message = "Team successfully edited!";
		redirectAttrs.addFlashAttribute("message", message);
		return "redirect:/team/list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteTeam(@PathVariable Integer id,
			RedirectAttributes redirectAttrs) {
		teamService.deleteTeam(id);
		String message = "Team successfully deleted!";
		redirectAttrs.addFlashAttribute("message", message);
		return "redirect:/team/list";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchTeam(@RequestParam("parameter") String parameter,
			@RequestParam("criteria") String criteria) {
		ModelAndView modelAndView = new ModelAndView();
		List<Team> teams = new ArrayList<Team>();
		Team team = new Team();
		String message = "";
		if (criteria.equals("name") && !parameter.isEmpty()) {
			teams = teamService.searchTeamByName(parameter);
		} else if (criteria.equals("id") && !parameter.isEmpty()) {
			try {
				team = teamService.searchTeamById(Integer.valueOf(parameter));
				teams.add(team);
			} catch (NumberFormatException e) {
				message = "Id must be integer";
				return listOfTeams(message);
			}
		} else if (parameter.isEmpty() || parameter.equals("")) {
			message = "Input search parameters";
			return listOfTeams(message);
		}
		if (teams.isEmpty() || teams.size() == 0 || team == null) {
			message = "No Result";
			return listOfTeams(message);
		}
		modelAndView.setViewName("list-of-teams");
		modelAndView.addObject("message", message);
		modelAndView.addObject("teams", teams);
		return modelAndView;
	}
}