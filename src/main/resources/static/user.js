const currentUserPanelData = document.getElementById("current_user_panel-data");
const currentAuthorisedUserData = document.getElementById("current_authorised_user-data");

let currentUser = () => {
    fetch ("http://localhost:8080/api/user", {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(res => res.json())
        .then(user => {
            if (user != null) {
                currentUserPanelData.innerHTML = `
                                <tr>
                                    <td> ${user.id} </td>
                                    <td> ${user.name} </td>
                                    <td> ${user.surname} </td>
                                    <td> ${user.age} </td>
                                    <td> ${user.email} </td>
                                    <td> ${user.roles.map((role) => role.name === "ROLE_USER" ? "User" : "Admin")} </td>
                                </tr>
                        `
                currentAuthorisedUserData.innerHTML = `
                    <p class="d-inline font-weight-bold">${user.email} With role ${user.roles.map((role) => role.name === "ROLE_USER" ? "User" : "Admin")}</p>`
            }
        })
}
currentUser();