
if __name__ == '__main__':
    None


class Employee:
    def __init__(self, first, last, pay):
        self.first = first
        self.last = last
        self.pay = pay
        self.email = first + '' + last +'' + '@gogole.com'

    @property
    def fullname(self):
        return self.first+' '+self.last

    @fullname.setter
    def fullname(self, name):
        first, last = name.split(' ')
        self.first = first
        self.last = last

    @fullname.deleter
    def fullname(self):
        del self.fullname

class Manager(Employee):
    def __init__(self, em, position):
        super(Manager, self).__init__(em.first, em.last, em.pay)
        self.position = position

    @classmethod
    def classcall(cls):
        print("classmethod called")

    @staticmethod
    def stmethod(param):
        print('stmethod called')

    def __repr__(self):
        return 'Employee:('+self.first+' '+self.last+' '+str(self.pay)+')'

    def __str__(self):
        return 'Manager:('+self.first+' '+self.last+' '+str(self.pay)+')'

    def __len__(self):
        return len(self.first)

