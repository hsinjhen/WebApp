package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.Team;

public interface TeamDAO {

	public void addTeam(Team team);

	public void updateTeam(Team team);

	public Team getTeam(int id);

	public void deleteTeam(int id);

	public List<Team> getTeams();

	public Team searchTeamById(int id);
	
	public List<Team> searchTeamByName(String name);
}