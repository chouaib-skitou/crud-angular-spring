export class Employee {
    id: number;
    firstName: string;
    lastName: string;
    emailId: string;
    phoneNumber: string;


    constructor(id: number, firstName: string, lastName: string, emailId: string, phoneNumber: string) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
    }
}
