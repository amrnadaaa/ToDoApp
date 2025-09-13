package com.project.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    private Connection conn;

    public  TaskDAO() throws Exception {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ToDo", "root", "azaneven2004");
    }

    public void addTask(Task task) throws Exception {
        String sql = "INSERT INTO tasks (title, week, is_finished) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, task.getTitle());
        ps.setInt(2, task.getWeek());
        ps.setBoolean(3, false);
        ps.executeUpdate();
        System.out.println("✅ Task added successfully!");
    }

    public List<Task> getTasksByWeek(int week) throws Exception {
        String sql = "SELECT * FROM tasks WHERE week = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, week);
        ResultSet rs = ps.executeQuery();

        List<Task> tasks = new ArrayList<>();
        while (rs.next()) {
            tasks.add(new Task(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getInt("week"),
                    rs.getBoolean("is_finished")
            ));
        }
        return tasks;
    }

    public List<Task> getFinishedTasks() throws Exception {
        String sql = "SELECT * FROM tasks WHERE is_finished = true";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        List<Task> tasks = new ArrayList<>();
        while (rs.next()) {
            tasks.add(new Task(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getInt("week"),
                    rs.getBoolean("is_finished")
            ));
        }
        return tasks;
    }

    public void finishTask(int id) throws Exception {
        String sql = "UPDATE tasks SET is_finished = true WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("✅ Task marked as finished!");
    }
}
