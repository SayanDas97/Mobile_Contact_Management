try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO contacts(name, phone) VALUES(?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, phone);

            ps.executeUpdate();

            System.out.println("Contact Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void searchContact(String name) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM contacts WHERE name=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Phone: " + rs.getString("phone"));
            } else {
                System.out.println("Contact Not Found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void deleteContact(String name) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM contacts WHERE name=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Contact Deleted Successfully!");
            else
                System.out.println("Contact Not Found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}